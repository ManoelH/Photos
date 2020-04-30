package com.manoelh.photos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manoelh.photos.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manoelh.photos.adapter.AlbumsListAdapter
import com.manoelh.photos.model.Album
import com.manoelh.photos.server.api.AlbumServiceRequest
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity() {

    private val mAlbumServiceRequest = AlbumServiceRequest()
    private var mAlbumsList: MutableList<Album> = mutableListOf()
    private lateinit var mAlbumListAdapter: AlbumsListAdapter
    private lateinit var mAlbumsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        mAlbumListAdapter = AlbumsListAdapter(mAlbumsList)
        mAlbumsRecyclerView = albumsRecyclerView
        loadAlbumsRecyclerView()
        setupAlbumsObserver()
    }

    private fun setupAlbumsObserver(){
        mAlbumServiceRequest.searchAlbumsFromAPI().observe(this, Observer { albums ->
            if (albums != null){
                mAlbumsList = albums.toMutableList()
                mAlbumListAdapter.setData(mAlbumsList)
            }
        })
    }

    private fun loadAlbumsRecyclerView() {
        mAlbumsRecyclerView.adapter = mAlbumListAdapter
        mAlbumsRecyclerView.layoutManager = LinearLayoutManager(this)
        mAlbumsRecyclerView.setHasFixedSize(true)
    }
}

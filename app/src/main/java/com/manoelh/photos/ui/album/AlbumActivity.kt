package com.manoelh.photos.ui.album

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manoelh.photos.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manoelh.photos.adapter.AlbumsListAdapter
import com.manoelh.photos.model.Album
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity(),
    AlbumContract.AlbumView {

    //private val mAlbumServiceRequest = AlbumServiceRequest()
    private var mAlbumsList: MutableList<Album> = mutableListOf()
    private lateinit var mAlbumListAdapter: AlbumsListAdapter
    private lateinit var mAlbumsRecyclerView: RecyclerView
    private lateinit var albumPresenter: AlbumPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        mAlbumListAdapter = AlbumsListAdapter(mAlbumsList)
        mAlbumsRecyclerView = albumsRecyclerView
        albumPresenter = AlbumPresenter(this)
        loadAlbumsRecyclerView()
        albumPresenter.setupAlbumsObserver()
//        setupAlbumsObserver()
    }
//
//    private fun setupAlbumsObserver(){
//        mAlbumServiceRequest.searchAlbumsFromAPI().observe(this, Observer { albums ->
//            if (albums != null){
//                mAlbumsList = albums.toMutableList()
//                mAlbumListAdapter.setData(mAlbumsList)
//            }
//        })
//    }

    private fun loadAlbumsRecyclerView() {
        mAlbumsRecyclerView.adapter = mAlbumListAdapter
        mAlbumsRecyclerView.layoutManager = LinearLayoutManager(this)
        mAlbumsRecyclerView.setHasFixedSize(true)
    }

    override fun showAlbums(albums: List<Album>) {
        mAlbumListAdapter.setData(albums)
    }

    override fun onDestroy() {
        super.onDestroy()
        albumPresenter.destroyView()
    }
}

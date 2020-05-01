package com.manoelh.photos.ui.album

import androidx.lifecycle.Observer
import com.manoelh.photos.model.Album
import com.manoelh.photos.server.api.AlbumServiceRequest

class AlbumPresenter(private var view: AlbumContract.AlbumView?): AlbumContract.AlbumPresenter {

    private val mAlbumServiceRequest = AlbumServiceRequest()
    private var mAlbumsList: MutableList<Album> = mutableListOf()

    override fun setupAlbumsObserver() {
        mAlbumServiceRequest.searchAlbumsFromAPI().observe(view!!, Observer { albums ->
            if (albums != null){
                mAlbumsList = albums.toMutableList()
                view!!.showAlbums(mAlbumsList)
            }
        })
    }

    override fun destroyView() {
        this.view = null
    }

}

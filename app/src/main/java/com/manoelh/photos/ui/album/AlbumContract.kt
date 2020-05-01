package com.manoelh.photos.ui.album

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.manoelh.photos.model.Album

interface AlbumContract {
    interface AlbumView : LifecycleOwner {
        fun showAlbums(albums: List<Album>)
    }

    interface AlbumPresenter{
        fun setupAlbumsObserver()
        fun destroyView()
    }
}
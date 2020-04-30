package com.manoelh.photos.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manoelh.photos.R
import com.manoelh.photos.model.Album


class AlbumsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private var albumTitle = itemView.findViewById<TextView>(R.id.albumTitle)
    fun bindColors(album: Album){
        albumTitle.text = album.title
    }
}
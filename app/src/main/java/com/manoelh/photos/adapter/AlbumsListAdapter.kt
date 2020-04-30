package com.manoelh.photos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manoelh.photos.R
import com.manoelh.photos.adapter.viewholder.AlbumsViewHolder
import com.manoelh.photos.model.Album

class AlbumsListAdapter(private var albums: List<Album>) : RecyclerView.Adapter<AlbumsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = inflate.inflate(R.layout.list_albums , parent, false)
        return AlbumsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albums.count()
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.bindColors(albums[position])
    }

    fun setData(albums: List<Album>){
        this.albums = albums
        notifyDataSetChanged()
    }
}
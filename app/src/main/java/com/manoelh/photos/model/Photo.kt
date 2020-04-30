package com.manoelh.photos.model

data class Photo(val albumId: Int, val id: Int, var title: String, var url: String, var thumbnailUrl: String)
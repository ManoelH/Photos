package com.manoelh.photos.server.api

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET


interface AlbumService {
    @GET("albums")
    fun readAlbumArray(): Call<JsonArray?>?
}
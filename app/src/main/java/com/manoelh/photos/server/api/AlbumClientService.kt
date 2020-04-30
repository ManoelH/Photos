package com.manoelh.photos.server.api

import com.google.gson.GsonBuilder
import com.manoelh.photos.server.Constants.Companion.BASE_URL_ALBUM
import com.manoelh.photos.server.Constants.Companion.DATE_FORMAT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AlbumClientService {

    companion object {
        private var albumService: AlbumService? = null
        fun getAlbum(): AlbumService? {

            if (albumService == null) {
                val gson = GsonBuilder()
                    .setDateFormat(DATE_FORMAT)
                    .create()
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL_ALBUM)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                albumService = retrofit.create<AlbumService>(AlbumService::class.java)
            }
            return albumService
        }
    }
}
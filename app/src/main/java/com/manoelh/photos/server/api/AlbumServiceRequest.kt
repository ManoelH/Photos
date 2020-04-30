package com.manoelh.photos.server.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import com.manoelh.photos.model.Album
import com.util.JsonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class AlbumServiceRequest {

    private val TAG = "AlbumServiceRequest"

    fun searchAlbumsFromAPI(): MutableLiveData<List<Album>> {

        val albums: MutableLiveData<List<Album>> = MutableLiveData()

        val serviceAPI: AlbumService? =
            AlbumClientService.getAlbum()
        val loadTeamCall: Call<JsonArray?>? = serviceAPI?.readAlbumArray()
        var albumArray: MutableList<Album> ?
        loadTeamCall?.enqueue(object : Callback<JsonArray?> {
            override fun onResponse(
                call: Call<JsonArray?>?, response: Response<JsonArray?>) {
                try {
                    val teamString: String = response.body().toString()
                    val listType: Type =
                        object : TypeToken<List<Album?>?>() {}.type
                    albumArray = JsonUtil.getListFromJson(teamString, listType)
                    albums.postValue(albumArray)
                } catch (e: Exception) {
                    //Log.d(TAG, Resources.getSystem().getString(1))
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<JsonArray?>?, t: Throwable) {
                Log.d(TAG, t.toString())
                albums.postValue(null)
            }
        })
        return albums
    }
}
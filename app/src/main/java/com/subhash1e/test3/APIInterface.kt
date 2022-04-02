package com.subhash1e.test3

import android.widget.Button
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {
    @GET("v1/{artist}/{title}")
    fun getLyricsData(@Path("artist") artist:String, @Path("title") title:String): Call<LyricsModel>
}
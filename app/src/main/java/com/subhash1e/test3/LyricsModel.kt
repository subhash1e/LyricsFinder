package com.subhash1e.test3

import com.google.gson.annotations.SerializedName

class LyricsModel {
    @SerializedName("lyrics")
    var lyrics:String? = null
    @SerializedName("error")
    var error:String? = null


}
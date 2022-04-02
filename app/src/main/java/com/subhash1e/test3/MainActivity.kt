package com.subhash1e.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var baseUrl = "https://api.lyrics.ovh/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val search:Button = findViewById(R.id.search_btn)
        val artist:TextView = findViewById(R.id.artist_name)
        val songName:TextView = findViewById(R.id.song_name)
        val lyrics:TextView = findViewById(R.id.song_lyrics)

        lyrics.movementMethod = ScrollingMovementMethod();
        search.setOnClickListener {
            if (artist.text.isEmpty() || songName.text.isEmpty()) {
                Toast.makeText(applicationContext, "Fill all the fields", Toast.LENGTH_LONG).show()
            }else {
                var retrofit = Retrofit.Builder().baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).build();

                val service = retrofit.create(APIInterface::class.java)
                val  call = service.getLyricsData(artist.text.toString(),songName.text.toString());
                call.enqueue(object: Callback<LyricsModel>{
                    override fun onResponse(call: Call<LyricsModel>, response: Response<LyricsModel> ) {

                            lyrics.text = response.body()?.lyrics


                    }

                    override fun onFailure(call: Call<LyricsModel>, t: Throwable) {

                    }

                })




            }

        }
    }
}
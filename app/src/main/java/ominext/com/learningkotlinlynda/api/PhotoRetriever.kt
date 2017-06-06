package ominext.com.learningkotlinlynda.api

import ominext.com.learningkotlinlynda.model.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by LuongHH on 6/6/2017.
 */
class PhotoRetriever {
    private val service: PhotoApi



    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(PhotoApi::class.java)
    }

    fun getPhoto(callback: Callback<PhotoList>) {
        val call = service.getPhoto()
        call.enqueue(callback)
    }
}
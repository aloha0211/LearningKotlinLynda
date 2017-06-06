package ominext.com.learningkotlinlynda.api

import ominext.com.learningkotlinlynda.model.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by LuongHH on 6/6/2017.
 */
interface PhotoApi {

    @GET("?key=5559215-4d23bba7c2554832e8ee11cec&q=nature&image_type=photo")
    fun getPhoto(): Call<PhotoList>
}
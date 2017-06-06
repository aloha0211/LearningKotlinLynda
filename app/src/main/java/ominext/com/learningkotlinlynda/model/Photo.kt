package ominext.com.learningkotlinlynda.model

import java.io.Serializable

/**
 * Created by LuongHH on 6/6/2017.
 */
data class Photo(val id: String,
                 val likes: Int,
                 val favorites: Int,
                 val tags: String,
                 val previousUrl: String,
                 val webFormatUrl: String) : Serializable {
}
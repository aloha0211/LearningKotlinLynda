package ominext.com.learningkotlinlynda.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import ominext.com.learningkotlinlynda.R
import ominext.com.learningkotlinlynda.model.Photo

/**
 * Created by LuongHH on 6/6/2017.
 */
class MainAdapter(var photos: List<Photo>,
                  var clickLisener: View.OnClickListener) : RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo = photos[position]
        holder?.tags?.text = photo.tags
        holder?.likes?.text = photo.likes.toString()
        holder?.favorites?.text = photo.favorites.toString()
        if (photo.previousUrl!= null) {
            Glide.with(holder?.tags?.context)
                    .load(photo.previousUrl)
                    .into(holder?.photoItem)
        }
    }

    fun getPhoto(adapterPosition: Int) : Photo {
        return photos[adapterPosition]
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tags: TextView
        var likes: TextView
        var favorites: TextView
        var photoItem: ImageView

        init {
            tags = itemView.findViewById(R.id.tags) as TextView
            likes = itemView.findViewById(R.id.likes) as TextView
            favorites = itemView.findViewById(R.id.favorites) as TextView
            photoItem = itemView.findViewById(R.id.photo_item) as ImageView

            if (clickLisener != null) {
                itemView.setOnClickListener(clickLisener)
            }
            itemView.tag = this
        }
    }
}
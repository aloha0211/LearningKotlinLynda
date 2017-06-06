package ominext.com.learningkotlinlynda.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.bumptech.glide.Glide

import ominext.com.learningkotlinlynda.R
import ominext.com.learningkotlinlynda.model.Photo

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val imageView = findViewById(R.id.imageView) as ImageView
        val photo = intent.getSerializableExtra(PHOTO) as Photo?
        photo?.webFormatUrl.let {
            Glide.with(this).load(photo?.webFormatUrl)
                    .into(imageView)
        }
        imageView.setOnClickListener { finish() }
    }

    companion object {
        val PHOTO = "PHOTO"
    }
}

package ominext.com.learningkotlinlynda.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import ominext.com.learningkotlinlynda.R
import ominext.com.learningkotlinlynda.adapter.MainAdapter
import ominext.com.learningkotlinlynda.api.PhotoRetriever
import ominext.com.learningkotlinlynda.model.Photo
import ominext.com.learningkotlinlynda.model.PhotoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var photos: List<Photo>? = null
    var adapter: MainAdapter? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        var retriever = PhotoRetriever()
        val callback = object : Callback<PhotoList> {
            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                Log.e("APIError", t.toString())
            }

            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                response?.isSuccessful.let {
                    this@MainActivity.photos = response?.body()?.hits
                    adapter = MainAdapter(this@MainActivity.photos!!, this@MainActivity)
                    recyclerView.adapter = adapter
                }
            }

        }

        retriever.getPhoto(callback)
    }

    override fun onClick(view: View?) {
        val intent = Intent(this, DetailActivity::class.java)
        val holder = view?.tag as MainAdapter.PhotoViewHolder
        intent.putExtra(DetailActivity.PHOTO, adapter?.getPhoto(holder.adapterPosition))
        startActivity(intent)
    }
}

package com.example.collesure

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        MyAsyncTask().execute()
        val imageView = findViewById<ImageView>(R.id.imageView)
        Glide.with(this)
            .load("https://s3-ap-northeast-1.amazonaws.com/cdn.bibi-star.jp/production/imgs/images/000/319/906/lqip.jpg?1559004209")
            .into(imageView)

    }

    inner class MyAsyncTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg p0: Void?): String? {
            return getHtml()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            textView.text = result
        }

    }

    fun getHtml(): String {
        val client = OkHttpClient()
        val req = Request.Builder().url("http://google.com").get().build()
        val resp = client.newCall(req).execute()
        return resp.body!!.string()
    }
}

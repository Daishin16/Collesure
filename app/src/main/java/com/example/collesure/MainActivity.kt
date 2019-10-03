package com.example.collesure

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyAsyncTask().execute()
        Glide.with(this)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQg101PJI38ezS5sWsa0uNgZ-cJ0QN3th2bxUulZ4VNQ_AXAbgS")
            .into(imageView)
    }

    inner class MyAsyncTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg p0: Void?): String? {
            return getHtml()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

        }

    }

    fun getHtml(): String {
        val client = OkHttpClient()
        val req =
            Request.Builder().url("http://www.google.com/search?q=猫&tbm=isch")
                .get().build()
        val resp = client.newCall(req).execute()
        return resp.body!!.string()
    }
}

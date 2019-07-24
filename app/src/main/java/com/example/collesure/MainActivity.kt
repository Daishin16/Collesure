package com.example.collesure

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        Glide.with(this)
            .load("https://stat.ameba.jp/user_images/20190205/11/puku164/cc/c1/j/o0250035514350866222.jpg?caw=800")
            .into(imageView)
        Glide.with(this)
            .load("https://gamewith.akamaized.net/img/ccf2972de1ae2ae39cf402b38db18570.jpg")
            .into(imageView2)
    }
}

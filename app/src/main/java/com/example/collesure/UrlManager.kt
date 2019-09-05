package com.example.collesure

import java.util.regex.Pattern

class UrlManager {
    val regex = "<img.+?src=\"(.+?)\".+?>"
    var request: String? = ""
    val imageUrlList = arrayListOf<String>()
    val pattern = Pattern.compile(regex)

    init {

    }

    fun getRequest(request: String?) {
        this.request = request
        addUrlInList()
    }

    fun addUrlInList() {
        val matcher = pattern.matcher(request)
        while (matcher.find()) {
            imageUrlList.add(matcher.group(1));
        }
    }

    fun getUrl():String{
        return imageUrlList[0]
    }

}

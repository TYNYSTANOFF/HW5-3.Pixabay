package com.example.hw5_3pixabay

import android.app.Application

class App:Application() {
    companion object{
        lateinit var api:PixabayApi
    }


    override fun onCreate() {
        super.onCreate()
        val  retrofitService = RetrofitService()
        api = retrofitService.api
    }
}
package com.example.hw5_3pixabay

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
   @GET("api/")
    fun getImage(
        @Query("key") key: String = "29399946-a42f55a5222355230f7daea38",
        @Query("q") q: String,
        @Query("page") page:Int,
        @Query("per_page") perPage:Int = 10
    )
            : Call<PixabayModel>

}

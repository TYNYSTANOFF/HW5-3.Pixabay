package com.example.hw5_3pixabay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.hw5_3pixabay.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var adapter = PixabayAdapter(listOf())
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
          binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
              override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                  super.onScrollStateChanged(recyclerView, newState)
              if (!recyclerView.canScrollVertically(1)){
                  ++page
                  doRequest(page)
                  }
              }

          })
            addPhotoBtn.setOnClickListener {
              ++page
                doRequest(page)
            }
            requestBtn.setOnClickListener {
                doRequest(page)
            }
        }
    }

    private fun ActivityMainBinding.doRequest(page : Int) {
        App.api.getImage(q = keyEd.text.toString(), page = page).enqueue(object : Callback<PixabayModel> {
            override fun onResponse(
                call: Call<PixabayModel>,
                response: Response<PixabayModel>
            ) {
                if (response.isSuccessful) {
                    response.body()?.hits?.let {
                        adapter = PixabayAdapter(it)
                        recyclerView.adapter = this@MainActivity.adapter
                    }

                }
            }

            override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                Log.e("ololo", "onFailure${t.message}")
            }



        })
    }}
//
//            private fun ActivityMainBinding.doAdd(page: Int) {
//                App.api.getImage(q = keyEd.text.toString(), perPage = 6, page = page)
//                    .enqueue(object : Callback<PixabayModel> {
//                        override fun onResponse(
//                            call: Call<PixabayModel>, response: Response<PixabayModel>
//                        ) {
//                            if (response.isSuccessful) {
//                                response.body()?.hits?.let {
//                                    adapter = PixabayAdapter(it)
//                                    recyclerView.adapter = adapter
//                                }
//                            }
//                        }
//
//                        override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
//                            Log.e("ololo", "onFailure${t.message}")
//                        }
//
//                    })
//            }
package com.semyong.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsActivity : AppCompatActivity() {

    private val newsViewModel: NewsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        newsViewModel.getNews {
//            it.observe(this, Observer {
//                println(it.toString())
//            })
//        }
    }

//        activity_main_rv.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = docsAdapter
//        }
}

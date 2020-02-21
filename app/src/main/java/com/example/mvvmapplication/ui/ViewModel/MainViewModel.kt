package com.example.mvvmapplication.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmapplication.Model.Articles
import com.example.mvvmapplication.Rest.repository.ArticleRepository

class MainViewModel() : ViewModel() {
    private lateinit var articleListObservable: LiveData<List<Articles>>

    init {
        articleListObservable = ArticleRepository.getInstance().getArticleList()
    }

    //exposing livedata articles query so ui can observe it
    fun getArticleListObservable(): LiveData<List<Articles>> = articleListObservable
}
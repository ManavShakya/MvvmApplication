package com.example.mvvmapplication.ui.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapplication.ui.Adapter.RecyclerAdapter
import com.example.mvvmapplication.Model.Articles
import com.example.mvvmapplication.R
import com.example.mvvmapplication.ui.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
    RecyclerAdapter.ArticleClicked {

    private lateinit var toolbar: Toolbar
    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerAdapter = RecyclerAdapter(
            R.layout.recycler_elements,
            this,
            this
        )
        init()

        val viewModel: MainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getArticleListObservable().observe(this, object : Observer<List<Articles>>{
            override fun onChanged(articles: List<Articles>?) {
                if (articles != null) {
                    recyclerAdapter.setArticleList(articles)
                }
            }

        })
    }

    private fun init() {
        recycler.setHasFixedSize(true)
        recycler.setItemViewCacheSize(20)
        recycler.isDrawingCacheEnabled = true
        recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = recyclerAdapter
    }

    override fun onArticleClicked(article: Articles?) {
        val intent = Intent(this,
            DescriptionActivity::class.java)
        intent.putExtra("article",article)
        startActivity(intent)
    }
}

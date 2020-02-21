package com.example.mvvmapplication.ui.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.mvvmapplication.Model.Articles
import com.example.mvvmapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val toolbar: Toolbar  = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val article: Articles = intent.getParcelableExtra("article")
        Picasso.with(this).load(article.urlToImage).into(image)
        titleText.text = article.title
        descriptionText.text = article.description
        contentText.text = article.content
        dateText.text = article.publishedAt
        authorText.text = article.author

        val actionBar:androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

}

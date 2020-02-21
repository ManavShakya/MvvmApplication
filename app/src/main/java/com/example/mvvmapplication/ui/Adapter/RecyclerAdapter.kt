package com.example.mvvmapplication.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapplication.Model.Articles
import com.example.mvvmapplication.R
import com.squareup.picasso.Picasso

class RecyclerAdapter(private var layout: Int,var context: Context?,var articleClicked: ArticleClicked)
    : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var articles: List<Articles>? = null

    interface ArticleClicked{
        fun onArticleClicked(article: Articles?)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val newsImageView: ImageView = itemView.findViewById(R.id.imageView)
        val newsText: TextView = itemView.findViewById(R.id.textView)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            articleClicked.onArticleClicked(articles?.get(adapterPosition))
        }
    }

    fun setArticleList(list: List<Articles>) {
        articles = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(layout, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val url = articles?.get(position)?.urlToImage
        Picasso.with(context)
            .load(url)
            .into(holder.newsImageView)

        holder.newsText.text = articles?.get(position)?.title ?: ""
    }

}
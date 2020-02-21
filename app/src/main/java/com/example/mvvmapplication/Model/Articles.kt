package com.example.mvvmapplication.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Articles(
                @SerializedName("author")val author: String,
                @SerializedName("title")val title: String,
                @SerializedName("description")val description: String,
                @SerializedName("url")val url:String,
                @SerializedName("urlToImage")val urlToImage: String,
                @SerializedName("publishedAt")val publishedAt: String,
                @SerializedName("content")val content: String
) : Parcelable
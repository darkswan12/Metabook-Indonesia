package com.example.metabook.data.retrofit.recommend

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecommendationResponse(
	@field:SerializedName("recommendations")
	val recommendations: List<RecommendationsItem?>? = null
): Parcelable
@Parcelize
data class ImageLinks(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("smallThumbnail")
	val smallThumbnail: String? = null
): Parcelable
@Parcelize
data class RecommendationsItem(

	@field:SerializedName("volumeInfo")
	val volumeInfo: VolumeInfo? = null,

	@field:SerializedName("etag")
	val etag: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("categories")
	val categories: List<String?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("selfLink")
	val selfLink: String? = null
): Parcelable
@Parcelize
data class VolumeInfo(

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("imageLinks")
	val imageLinks: ImageLinks? = null,

	@field:SerializedName("description")
	val description: String? = null
): Parcelable

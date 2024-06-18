package com.example.metabook.data.retrofit.recommend


import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceRecom {

    @POST("volumes/{id}")
    fun bookById(
        @Path("id") bookId: String,
        @Query("orderBy") category: String
    ): Flowable<RecommendationResponse>

    @GET("volumes")
    fun bookRecommendation(
        @Query("q") query: String,
    ): Flowable<RecommendationResponse>
}
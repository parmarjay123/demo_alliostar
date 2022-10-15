package com.example.practicalcategorylist.retroit

import com.example.practicalcategorylist.Categories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Singleton

interface RetrofitService {
    @FormUrlEncoded
    @POST("v28/company_list_by_category")
    fun getAllCategories(
        @Field("mode") mode: String,
        @Field("page") page: Int
    ): Call<Categories>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://devops.tileswale.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }

    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule1 {
        @Provides
        @Singleton
        fun providerDemo(): RetrofitService = retrofitService!!
    }


}

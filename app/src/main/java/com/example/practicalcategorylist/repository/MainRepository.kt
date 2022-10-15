package com.example.practicalcategorylist.repository

import com.example.practicalcategorylist.retroit.RetrofitService
import javax.inject.Inject

class MainRepository @Inject constructor(private  val retrofitService: RetrofitService) {
  fun getAllmovies()= retrofitService.getAllCategories("listing",1)
}
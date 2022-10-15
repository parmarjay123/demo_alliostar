package com.example.practicalcategorylist.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicalcategorylist.Categories
import com.example.practicalcategorylist.Data
import com.example.practicalcategorylist.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Data>>()
    val errorMessage = MutableLiveData<String>()

    fun getCategories() {
        val response = repository.getAllmovies()

        response.enqueue(object : Callback<Categories> {
            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                movieList.postValue(response.body()?.results?.data ?: emptyList())
            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}
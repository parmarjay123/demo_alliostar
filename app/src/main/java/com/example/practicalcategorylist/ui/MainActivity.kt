package com.example.practicalcategorylist.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.practicalcategorylist.R
import com.example.practicalcategorylist.databinding.ActivityMainBinding
import com.example.practicalcategorylist.models.StudentData
import com.example.practicalcategorylist.models.StudentList
import com.example.practicalcategorylist.retroit.RetrofitService
import com.example.practicalcategorylist.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var student_list= ArrayList<StudentData>()
    var studentName= arrayListOf<String>("Jay","Arth","Darshak","Rasik","Parth")
    var en_no= arrayListOf<String>("1234","5678","1441","5461","4567")
    var clg_name= arrayListOf<String>("LJ","LX Uni","Marwadi edu","SREZ ","Atmiya")
    var phy_mark= arrayListOf<String>("52","32","46","33","40")
    var cha_mark= arrayListOf<String>("59","31","52","38","48")
    var eng_mark= arrayListOf<String>("55","30","45","32","39")
    var maths_mark= arrayListOf<String>("59","28","44","29","45")
    var grade= arrayListOf<String>("A","C","B","C","B")


    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



       /* for (i in student_list){
            var data=StudentData()
            student_list[i].student_name
            student_list[i].student_name= studentName[i]
            student_list[i].physics_mark= phy_mark[i]
            student_list[i].chamistry_mark= cha_mark[i]
            student_list[i].english_mark= eng_mark[i]
            student_list[i].maths_mark= maths_mark[i]
            student_list[i].en_no= en_no[i]
            student_list[i].grade= grade[i]
        }
*/

        binding.recyclerview.adapter = adapter


      /*
        binding.recyclerview.layoutManager = MaxCountLayoutManager(this).apply { setMaxCount(9) }
        simpleProgressBar.visibility = View.VISIBLE
        viewModel.movieList.observe(this, Observer {
            adapter.setMovieList(it)
            simpleProgressBar.visibility = View.GONE
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()

        })

        viewModel.getCategories()*/

    }
}
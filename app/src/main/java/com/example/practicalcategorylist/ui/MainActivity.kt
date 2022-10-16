package com.example.practicalcategorylist.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.practicalcategorylist.R
import com.example.practicalcategorylist.databinding.ActivityMainBinding
import com.example.practicalcategorylist.models.StudentData
import com.example.practicalcategorylist.retroit.RetrofitService
import com.example.practicalcategorylist.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var student_list = ArrayList<StudentData>()
    var studentName = arrayListOf<String>(
        "Jay",
        "Artest",
        "Danver",
        "Rens",
        "Parno",
        "Alex",
        "Benzo",
        "Chris",
        "Mark",
        "Elon"
    )
    var en_no = arrayListOf<String>(
        "1234",
        "5678",
        "1441",
        "5461",
        "4567",
        "5656",
        "5758",
        "5759",
        "5940",
        "6600"
    )
    var clg_name = arrayListOf<String>(
        "LJ",
        "LX Uni",
        "Marwadi edu",
        "SREZ ",
        "Atmiya",
        "GTU",
        "octa",
        "Msu",
        "Ayurveda",
        "ITI"
    )
    var phy_mark = arrayListOf<String>("52", "32", "46", "33", "40", "52", "32", "46", "33", "40")
    var cha_mark = arrayListOf<String>("59", "31", "52", "38", "48", "59", "31", "52", "38", "48")
    var eng_mark = arrayListOf<String>("55", "30", "45", "32", "39", "55", "30", "45", "32", "39")
    var maths_mark = arrayListOf<String>("59", "28", "44", "29", "45", "59", "28", "44", "29", "45")
    var grade = arrayListOf<String>("A", "C", "B", "C", "B", "A", "C", "B", "C", "B")


    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        studentName.forEachIndexed { index, element ->
            var data = StudentData(
                student_name = studentName[index],
                chamistry_mark = cha_mark[index],
                collage_name = clg_name[index],
                en_no = en_no[index],
                english_mark = eng_mark[index],
                grade = grade[index],
                maths_mark = maths_mark[index],
                physics_mark = phy_mark[index],
                student_id = studentName[index]
            )
            student_list.add(data)
        }

        adapter.setMovieList(student_list)
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
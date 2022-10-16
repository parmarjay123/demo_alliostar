package com.example.practicalcategorylist.models

import com.example.practicalcategorylist.Results

data class StudentList(
    val data: List<StudentData>
    )

data class StudentData(
    var student_id: String,
    var student_name: String,
    var en_no: String,
    var collage_name: String,
    var physics_mark: String,
    var english_mark: String,
    var maths_mark: String,
    var chamistry_mark: String,
    var grade: String,
    )
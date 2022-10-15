package com.example.practicalcategorylist.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicalcategorylist.databinding.ItemCategoriesBinding
import com.example.practicalcategorylist.models.StudentData
import java.util.*


class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var studentData = mutableListOf<StudentData>()

    fun setMovieList(movies: List<StudentData>) {
        this.studentData = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemCategoriesBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val categoriesItem = studentData[position]

        holder.binding.tvStudentName.text="Student Name :- ${categoriesItem.student_name}"
        holder.binding.tvCollageCode.text="Collage Name :- ${categoriesItem.collage_name}"
        holder.binding.tvEnNo.text="En_No :- ${categoriesItem.en_no}"


    }

    override fun getItemCount(): Int {
        return studentData.size
    }
}

class MainViewHolder(val binding: ItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {

}
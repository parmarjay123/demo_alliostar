package com.example.practicalcategorylist

data class Categories(
    val results: Results
)

data class Results(
    val `data`: List<Data>,
    val message: String,
    val sorting_random_id: String,
    val status: String
)

data class Data(
    val company_id: String,
    val company_isFeatured: Boolean,
    val company_isVerified: Boolean,
    val company_latitude: String,
    val company_logitude: String,
    val company_logo: String,
    val company_name: String
)
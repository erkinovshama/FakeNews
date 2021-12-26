package com.itacademy.fakenews.models

import java.io.Serializable

data class CategoryModel(
    var category: Categories,
    var name: Categories,
    var news: List<News>
) : Serializable


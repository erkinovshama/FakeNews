package com.itacademy.fakenews.models

import java.io.Serializable

class News(
    var category: Categories,
    var description: String,
    var name: String,
    var imageUrl: String
) : Serializable
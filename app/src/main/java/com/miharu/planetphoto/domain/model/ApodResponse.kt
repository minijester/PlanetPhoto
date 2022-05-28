package com.miharu.planetphoto.domain.model

data class ApodResponse(
    val title: String,
    val explanation: String,
    val date: String,
    val copyright: String,
    val url: String,
)
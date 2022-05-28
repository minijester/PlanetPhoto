package com.miharu.planetphoto.data.repository

import com.miharu.planetphoto.domain.model.ApodResponse

interface MainRepository {
    suspend fun getApodList(): List<ApodResponse>
    suspend fun insertApodList()
    suspend fun deleteApodList()
}
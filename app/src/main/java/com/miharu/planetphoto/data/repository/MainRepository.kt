package com.miharu.planetphoto.data.repository

import com.miharu.planetphoto.domain.model.ApodResponse

interface MainRepository {
    suspend fun getApodList(startDate: String, endDate: String): List<ApodResponse>
    suspend fun insertApodList(apodList: List<ApodResponse>)
    suspend fun deleteApodList()
}
package com.miharu.planetphoto.data.datasource.remote

import com.miharu.planetphoto.data.datasource.API_KEY
import com.miharu.planetphoto.data.datasource.APOD
import com.miharu.planetphoto.domain.model.ApodResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainCloudDataSource {

    @GET(APOD)
    suspend fun getApodList(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
    ): Response<List<ApodResponse>>
}
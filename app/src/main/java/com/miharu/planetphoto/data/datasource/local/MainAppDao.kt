package com.miharu.planetphoto.data.datasource.local

import androidx.room.Dao
import com.miharu.planetphoto.data.datasource.APOD_COUNT
import com.miharu.planetphoto.domain.model.ApodResponse
import retrofit2.http.Query

@Dao
interface MainAppDao {

    fun getApodList(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("count") count: Int = APOD_COUNT,
    ): List<ApodResponse>
}
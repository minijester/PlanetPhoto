package com.miharu.planetphoto.data.datasource.local

import androidx.room.*
import com.miharu.planetphoto.domain.model.ApodResponse


@Dao
interface MainAppDao {

    @Query("SELECT * FROM apod_table")
    fun getApodList(): List<ApodResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApodList(apodList: List<ApodResponse>)

    @Query("DELETE from apod_table")
    suspend fun deleteApodList()
}
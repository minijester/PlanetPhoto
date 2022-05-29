package com.miharu.planetphoto.data.datasource.local

import androidx.room.*
import com.miharu.planetphoto.data.datasource.APOD_COUNT
import com.miharu.planetphoto.domain.model.ApodResponse


@Dao
interface MainAppDao {

    @Query("SELECT * FROM apod_table LIMIT :count")
    fun getApodList(
        count: Int = APOD_COUNT,
    ): List<ApodResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertApodList(apodList: List<ApodResponse>)

    @Query("DELETE from apod_table")
    fun deleteApodList()
}
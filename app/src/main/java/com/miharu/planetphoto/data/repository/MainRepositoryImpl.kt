package com.miharu.planetphoto.data.repository

import com.miharu.planetphoto.data.datasource.local.MainAppDao
import com.miharu.planetphoto.data.datasource.remote.MainCloudDataSource
import com.miharu.planetphoto.domain.model.ApodResponse
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainCloudDataSource: MainCloudDataSource,
    private val mainAppDao: MainAppDao
) : MainRepository {

    override suspend fun getApodList(): List<ApodResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun insertApodList() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteApodList() {
        TODO("Not yet implemented")
    }

}
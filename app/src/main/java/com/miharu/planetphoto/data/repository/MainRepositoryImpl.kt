package com.miharu.planetphoto.data.repository

import com.miharu.planetphoto.data.datasource.local.MainAppDao
import com.miharu.planetphoto.data.datasource.remote.MainCloudDataSource
import com.miharu.planetphoto.domain.model.ApodResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val mainCloudDataSource: MainCloudDataSource,
    private val mainAppDao: MainAppDao
) : MainRepository {

    override suspend fun getApodList(startDate: String, endDate: String): List<ApodResponse> {
        val apodList = mutableListOf<ApodResponse>()
        withContext(ioDispatcher) {
            val response = mainCloudDataSource.getApodList(startDate, endDate)
            if (response.isNotEmpty()) insertApodList(response)
            apodList.addAll(response)
        }
        return apodList
    }

    override suspend fun insertApodList(apodList: List<ApodResponse>) {
        if (apodList.isNotEmpty()) {
            withContext(ioDispatcher){
                deleteApodList()
                mainAppDao.insertApodList(apodList)
            }
        }
    }

    override suspend fun deleteApodList() {
        mainAppDao.deleteApodList()
    }
}
package com.miharu.planetphoto.data.repository

import com.miharu.planetphoto.core.di.IoDispatcher
import com.miharu.planetphoto.data.datasource.local.MainAppDao
import com.miharu.planetphoto.data.datasource.remote.MainCloudDataSource
import com.miharu.planetphoto.domain.model.ApodResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val mainCloudDataSource: MainCloudDataSource,
    private val mainAppDao: MainAppDao
) : MainRepository {

    override suspend fun getApodList(startDate: String, endDate: String): List<ApodResponse> {
        val apodList = mutableListOf<ApodResponse>()
        withContext(ioDispatcher) {
            val response = mainCloudDataSource.getApodList(startDate = startDate, endDate = endDate)
            if (response.isSuccessful) {
                val responseList = response.body() ?: listOf()
                if (responseList.isNotEmpty()) insertApodList(responseList)
                apodList.addAll(responseList)
            }
        }
        return apodList
    }

    override suspend fun insertApodList(apodList: List<ApodResponse>) {
        if (apodList.isNotEmpty()) {
            deleteApodList()
            mainAppDao.insertApodList(apodList)
        }
    }

    override suspend fun deleteApodList() {
        mainAppDao.deleteApodList()
    }
}
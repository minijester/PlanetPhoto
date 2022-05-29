package com.miharu.planetphoto.data.repository

import com.miharu.planetphoto.core.di.IoDispatcher
import com.miharu.planetphoto.core.extension.formatDefaultPattern
import com.miharu.planetphoto.data.datasource.local.MainAppDao
import com.miharu.planetphoto.data.datasource.remote.MainCloudDataSource
import com.miharu.planetphoto.domain.model.ApodResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.LocalDate
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val mainCloudDataSource: MainCloudDataSource,
    private val mainAppDao: MainAppDao
) : MainRepository {

    override suspend fun getApodList(startDate: String?, endDate: String?): List<ApodResponse> {
        val apodList = mutableListOf<ApodResponse>()
        if (startDate == null || endDate == null) {
            withContext(ioDispatcher) {
                val apodListLocal = fetchApodListLocal()
                if (apodListLocal.isEmpty()) {
                    val apodListRemote = fetchApodListRemote(
                        startDate = getDefaultStartDate(),
                        endDate = getDefaultEndDate()
                    )
                    apodList.addAll(apodListRemote)
                } else {
                    apodList.addAll(apodListLocal)
                }
            }
        } else {
            withContext(ioDispatcher) {
                val apodListRemote = fetchApodListRemote(startDate, endDate)
                apodList.addAll(apodListRemote)
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

    private fun fetchApodListLocal(): List<ApodResponse> {
        return mainAppDao.getApodList()
    }

    private suspend fun fetchApodListRemote(
        startDate: String,
        endDate: String
    ): List<ApodResponse> {
        val apodList = mutableListOf<ApodResponse>()
        val response =
            mainCloudDataSource.getApodList(startDate = startDate, endDate = endDate)
        if (response.isSuccessful) {
            if (!response.body().isNullOrEmpty()) {
                apodList.addAll(response.body() ?: emptyList())
                insertApodList(apodList)
            }
        }
        return apodList
    }

    private fun getDefaultStartDate() =
        LocalDate.now().minusDays(DEFAULT_START_DATE).formatDefaultPattern()

    private fun getDefaultEndDate() = LocalDate.now().formatDefaultPattern()

    companion object {
        const val DEFAULT_START_DATE = 30L
    }
}
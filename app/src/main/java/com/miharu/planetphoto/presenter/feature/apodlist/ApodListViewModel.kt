package com.miharu.planetphoto.presenter.feature.apodlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.miharu.planetphoto.core.base.BaseViewModel
import com.miharu.planetphoto.domain.model.ApodResponse
import com.miharu.planetphoto.domain.usecase.GetApodListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApodListViewModel @Inject constructor(
    private val getApodListUseCase: GetApodListUseCase
) : BaseViewModel() {

    private val _apodList: MutableLiveData<List<ApodResponse>> = MutableLiveData()
    val apodList: LiveData<List<ApodResponse>> = _apodList

    init {
        getApodList()
    }

    fun getApodList(startDate: String = "55", endDate: String = "55") {
        viewModelScope.launch {
            val fetchApodList = getApodListUseCase.invoke(
                GetApodListUseCase.Params(
                    startDate = startDate,
                    endDate = endDate
                )
            )
            _apodList.value = fetchApodList
        }
    }
}
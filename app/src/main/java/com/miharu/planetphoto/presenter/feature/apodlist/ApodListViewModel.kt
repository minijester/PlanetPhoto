package com.miharu.planetphoto.presenter.feature.apodlist

import androidx.lifecycle.viewModelScope
import com.miharu.planetphoto.core.base.BaseViewModel
import com.miharu.planetphoto.domain.model.ApodResponse
import com.miharu.planetphoto.domain.usecase.GetApodListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApodListViewModel @Inject constructor(
    private val getApodListUseCase: GetApodListUseCase
) : BaseViewModel() {

    private val _apodListUiState = MutableStateFlow<ApodListUiState>(ApodListUiState.Empty)
    val apodListUiState: StateFlow<ApodListUiState> get() = _apodListUiState

    init {
        getApodList()
    }

    fun getApodList(
        startDate: String? = null,
        endDate: String? = null
    ) {
        viewModelScope.launch {
            _apodListUiState.value = ApodListUiState.Loading
            val fetchApodList = getApodListUseCase.invoke(
                GetApodListUseCase.Params(
                    startDate = startDate,
                    endDate = endDate
                )
            )
            if (fetchApodList.isNotEmpty()) _apodListUiState.value =
                ApodListUiState.Success(fetchApodList)
            else _apodListUiState.value = ApodListUiState.Empty
        }
    }
}

sealed class ApodListUiState {
    data class Success(val apodList: List<ApodResponse>) : ApodListUiState()
    object Loading : ApodListUiState()
    object Empty : ApodListUiState()
}
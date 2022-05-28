package com.miharu.planetphoto.domain.usecase

import com.miharu.planetphoto.core.base.BaseUseCaseWithParams
import com.miharu.planetphoto.data.repository.MainRepository
import com.miharu.planetphoto.domain.model.ApodResponse
import javax.inject.Inject

class GetApodListUseCase @Inject constructor(
    private val mainRepository: MainRepository
) : BaseUseCaseWithParams<GetApodListUseCase.Params, List<ApodResponse>> {

    override suspend fun run(params: Params): List<ApodResponse> {
        return mainRepository.getApodList()
    }

    data class Params(
        val startDate: String,
        val endDate: String,
    )

}
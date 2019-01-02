package com.ovrbach.kitabsawtichallenge.general

import androidx.lifecycle.MutableLiveData
import com.ovrbach.kitabsawtichallenge.base.BaseViewModel
import com.ovrbach.kitabsawtichallenge.common.entity.OverviewResponse
import com.ovrbach.kitabsawtichallenge.general.repository.Repository
import com.ovrbach.kitabsawtichallenge.remote.ServiceProvider
import kotlinx.coroutines.launch

class GeneralViewModel : BaseViewModel() {

    val repository: Repository by lazy {
        Repository(
            ServiceProvider.overviewService
        )
    }

    val overview: MutableLiveData<OverviewResponse> by lazy {
        MutableLiveData<OverviewResponse>().also {
            fetchOverview()
        }
    }

    private fun fetchOverview() {
        launch {
            overview.postValue(repository.getOverview().await())
        }
    }

}
package com.ovrbach.kitabsawtichallenge.general

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ovrbach.kitabsawtichallenge.base.BaseApplicationViewModel
import com.ovrbach.kitabsawtichallenge.common.entity.Content
import com.ovrbach.kitabsawtichallenge.common.entity.OverviewResponse
import com.ovrbach.kitabsawtichallenge.general.repository.Repository
import com.ovrbach.kitabsawtichallenge.local.ContentDbs
import com.ovrbach.kitabsawtichallenge.remote.ServiceProvider
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GeneralViewModel(application: Application) : BaseApplicationViewModel(application) {

    val repository: Repository by lazy {
        Repository(
                ServiceProvider.overviewService,
                ContentDbs.getInstance(application)
        )
    }

    val overview: MutableLiveData<OverviewResponse> by lazy {
        MutableLiveData<OverviewResponse>().also {
            fetchOverview()
        }
    }

    val content: MutableLiveData<Content> by lazy {
        MutableLiveData<Content>().also {
            loadContent()
        }
    }


    private fun fetchOverview() {
        launch {
            overview.postValue(repository.getOverview().await())
        }
    }

    private fun loadContent() {
        launch {
            val loadedContent = async { repository.loadContent() }.await()
            if (loadedContent == null) {
                val extracted = repository.extractAssetsJsonToContent(getApplication())
                repository.storeContent(extracted)
                content.postValue(extracted)
            }
            content.postValue(loadedContent)
        }
    }


}
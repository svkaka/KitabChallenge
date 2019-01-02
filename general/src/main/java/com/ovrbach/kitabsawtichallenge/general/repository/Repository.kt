package com.ovrbach.kitabsawtichallenge.general.repository

import android.content.Context
import com.google.gson.Gson
import com.ovrbach.kitabsawtichallenge.common.contract.Overview
import com.ovrbach.kitabsawtichallenge.common.entity.Content
import com.ovrbach.kitabsawtichallenge.common.entity.OverviewResponse
import com.ovrbach.kitabsawtichallenge.local.ContentDbs
import com.ovrbach.kitabsawtichallenge.local.entity.ContentEntity
import com.ovrbach.kitabsawtichallenge.local.entity.convertToContentEntity
import com.ovrbach.kitabsawtichallenge.remote.OverviewService
import kotlinx.coroutines.Deferred
import java.io.InputStreamReader

class Repository(
    private val remoteRepository: OverviewService,
    private val localRepository: ContentDbs
) {

    fun getOverview(): Deferred<OverviewResponse> {
        return remoteRepository.getOverview()
    }

    fun updateOverview(overviewResponse: OverviewResponse) {
        localRepository.contentDao().updateOverview(
            version = overviewResponse.version,
            overview = overviewResponse.overview,
            manifesto = overviewResponse.manifesto
        )
    }

    fun loadContent(): Content? {
        return localRepository.contentDao().getContent()
    }

    fun storeContent(content: Content) {
        localRepository.contentDao().insertContent(content.convertToContentEntity())
    }

    fun extractAssetsJsonToContent(context: Context): Content {
        return Gson().fromJson(InputStreamReader(context.assets.open("data.json")), Content::class.java)
    }


}
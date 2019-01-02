package com.ovrbach.kitabsawtichallenge.general.repository

import com.ovrbach.kitabsawtichallenge.common.contract.Overview
import com.ovrbach.kitabsawtichallenge.common.entity.OverviewResponse
import com.ovrbach.kitabsawtichallenge.remote.OverviewService
import kotlinx.coroutines.Deferred

class Repository(
    val remoteRepository: OverviewService
) {

    //todo not public
    fun getOverview(): Deferred<OverviewResponse> {
        return remoteRepository.getOverview()
    }

    fun storeOverview(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
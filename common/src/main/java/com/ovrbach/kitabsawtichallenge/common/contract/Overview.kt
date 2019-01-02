package com.ovrbach.kitabsawtichallenge.common.contract

import com.ovrbach.kitabsawtichallenge.common.entity.OverviewResponse
import kotlinx.coroutines.Deferred

interface Overview {
    fun getOverview(): Deferred<OverviewResponse>
    fun storeOverview(): Boolean
}
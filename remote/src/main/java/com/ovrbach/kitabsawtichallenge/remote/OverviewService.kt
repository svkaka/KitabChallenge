package com.ovrbach.kitabsawtichallenge.remote

import com.ovrbach.kitabsawtichallenge.common.entity.OverviewResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

const val BASE_URL = "http://www.mocky.io/v2/"

interface OverviewService {

    @GET("5c2c00412e00008300e8747b")
    fun getOverview(): Deferred<OverviewResponse>

}
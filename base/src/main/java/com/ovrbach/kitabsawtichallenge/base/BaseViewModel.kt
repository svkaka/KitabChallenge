package com.ovrbach.kitabsawtichallenge.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel() : ViewModel(), CoroutineScope {
    private val dispatcher = Dispatchers.IO
    private val job = Job()

    // handler for handling exceptions in coroutines
    private val handler = CoroutineExceptionHandler { _, ex ->
        ex.printStackTrace()
    }

    override val coroutineContext: CoroutineContext
        get() = job + dispatcher + handler

    override fun onCleared() {
        super.onCleared()
        job.cancel() // all children jobs will be cancelled automatically
    }
}
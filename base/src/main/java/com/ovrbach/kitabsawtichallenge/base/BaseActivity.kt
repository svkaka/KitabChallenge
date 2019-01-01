package com.ovrbach.kitabsawtichallenge.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity<AVM : BaseViewModel>(private val viewModelClass: Class<AVM>) : AppCompatActivity() {

    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
    }


}
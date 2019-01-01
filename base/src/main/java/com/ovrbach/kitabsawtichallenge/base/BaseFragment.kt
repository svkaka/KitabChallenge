package com.ovrbach.kitabsawtichallenge.base


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders


abstract class BaseFragment<VM : BaseViewModel>(
    private val fragmentScopedViewModelClass: Class<VM>
) : Fragment() {

    protected lateinit var viewModel: VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as? FragmentActivity)?.let { activity ->
            viewModel = ViewModelProviders.of(activity).get(fragmentScopedViewModelClass)
        } ?: throw IllegalStateException("This type of fragment must be attached to activity")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

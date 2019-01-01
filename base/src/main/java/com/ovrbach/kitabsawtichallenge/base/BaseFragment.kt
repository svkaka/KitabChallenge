package com.ovrbach.kitabsawtichallenge.base


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders


abstract class BaseFragment<
        AVM : BaseViewModel>(
        private val activityScopedViewModelClass: Class<AVM>
) : Fragment() {

    protected var activityViewModel: AVM? = null

    override

    fun onAttach(context: Context) {
        super.onAttach(context)
        (context as? BaseActivity<*>)?.let { activity ->
            activityViewModel = ViewModelProviders.of(activity).get(activityScopedViewModelClass)
        } ?: throw IllegalStateException("This type of fragment must be attached to BaseActivity")
    }

}

package com.ovrbach.kitabsawtichallenge.general.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ovrbach.kitabsawtichallenge.base.BaseFragment
import com.ovrbach.kitabsawtichallenge.general.GeneralViewModel
import com.ovrbach.kitabsawtichallenge.general.R
import kotlinx.android.synthetic.main.fragment_overview.view.*

class OverviewFragment : BaseFragment<GeneralViewModel>(GeneralViewModel::class.java) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityViewModel?.overview?.observe(this, Observer { overviewResponse ->
            view.fragment_overview_overview.text = overviewResponse.overview
            view.fragment_overview_manifesto.text = overviewResponse.manifesto
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            OverviewFragment()
    }
}
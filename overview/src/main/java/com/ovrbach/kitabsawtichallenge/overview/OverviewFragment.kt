package com.ovrbach.kitabsawtichallenge.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ovrbach.kitabsawtichallenge.base.BaseFragment

class OverviewFragment :  Fragment(){
        //BaseFragment<OverviewViewModel>(OverviewViewModel::class.java) {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                OverviewFragment()
    }
}
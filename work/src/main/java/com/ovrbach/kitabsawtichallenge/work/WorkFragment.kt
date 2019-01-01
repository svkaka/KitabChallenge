package com.ovrbach.kitabsawtichallenge.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ovrbach.kitabsawtichallenge.base.BaseFragment

class WorkFragment : BaseFragment<WorkViewModel>(WorkViewModel::class.java) {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                WorkFragment()
    }
}
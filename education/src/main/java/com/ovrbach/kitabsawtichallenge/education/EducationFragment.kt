package com.ovrbach.kitabsawtichallenge.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ovrbach.kitabsawtichallenge.base.BaseFragment

class EducationFragment : BaseFragment<EducationViewModel>(EducationViewModel::class.java) {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_education, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                EducationFragment()
    }
}
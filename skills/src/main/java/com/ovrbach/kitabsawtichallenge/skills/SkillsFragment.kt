package com.ovrbach.kitabsawtichallenge.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ovrbach.kitabsawtichallenge.base.BaseFragment

class SkillsFragment : BaseFragment<SkillsViewModel>(SkillsViewModel::class.java) {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skills, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                SkillsFragment()
    }
}
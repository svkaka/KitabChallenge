package com.ovrbach.kitabsawtichallenge.general.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ovrbach.kitabsawtichallenge.base.BaseFragment
import com.ovrbach.kitabsawtichallenge.general.GeneralViewModel
import com.ovrbach.kitabsawtichallenge.general.R
import kotlinx.android.synthetic.main.fragment_education.view.*

class EducationFragment : BaseFragment<GeneralViewModel>(GeneralViewModel::class.java) {

    val listAdapter = EducationAdapter()

    override

    fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_education, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.fragment_education_recycler.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }

        activityViewModel?.content?.observe(this, Observer { content ->
            if (content != null) {
                val eduProject = content.education.map { education ->
                    EducationProjects(
                            content.projects.filter { education.name == it.company }, education)
                }

                listAdapter.submitList(eduProject)
            }
        })

    }
}
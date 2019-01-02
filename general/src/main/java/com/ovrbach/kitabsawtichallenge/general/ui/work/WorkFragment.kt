package com.ovrbach.kitabsawtichallenge.general.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ovrbach.kitabsawtichallenge.base.BaseFragment
import com.ovrbach.kitabsawtichallenge.general.GeneralViewModel
import com.ovrbach.kitabsawtichallenge.general.R
import com.ovrbach.kitabsawtichallenge.general.ui.education.EducationProjects
import kotlinx.android.synthetic.main.fragment_education.view.*
import kotlinx.android.synthetic.main.fragment_work.view.*

class WorkFragment : BaseFragment<GeneralViewModel>(GeneralViewModel::class.java) {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)

    }

    private val listAdapter = WorkAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.fragment_work_recycler.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }

        activityViewModel?.content?.observe(this, Observer { content ->
            if (content != null) {
                val companyNames = content.projects.distinctBy { it.company }.map { it.company }
                val comProject = companyNames.map { companyName ->
                    CompanyProjects(
                            content.projects.filter { companyName == it.company },
                            companyName
                    )
                }
                listAdapter.submitList(comProject)
            }
        })
    }
}
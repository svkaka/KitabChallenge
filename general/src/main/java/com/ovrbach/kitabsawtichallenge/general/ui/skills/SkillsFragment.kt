package com.ovrbach.kitabsawtichallenge.general.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager
import com.ovrbach.kitabsawtichallenge.base.BaseFragment
import com.ovrbach.kitabsawtichallenge.common.entity.Content
import com.ovrbach.kitabsawtichallenge.general.GeneralViewModel
import com.ovrbach.kitabsawtichallenge.general.R
import com.ovrbach.kitabsawtichallenge.general.ui.work.CompanyProjects
import kotlinx.android.synthetic.main.fragment_skills.view.*

const val SPAN_COUNT = 2

class SkillsFragment : BaseFragment<GeneralViewModel>(GeneralViewModel::class.java) {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skills, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityViewModel?.content?.observe(this, Observer {
            if (it != null) {
                loadRecycler(it)
            }
        })
    }

    fun loadRecycler(content: Content) {
        val techUsed = content.projects.flatMap { it.techUsed }.toSet()
        techUsed.map { }

        val skillProjects = techUsed.map { tech ->
            SkillProjects(
                    content.projects.filter { project -> project.techUsed.contains(tech) }.map { it.name },
                    tech
            )
        }
        view?.fragment_skills_recycler?.apply {

            val spannedGridLayoutManager = SpannedGridLayoutManager(
                    orientation = SpannedGridLayoutManager.Orientation.VERTICAL,
                    spans = NUMBER_OF_COLUMNS)
            layoutManager = spannedGridLayoutManager

            adapter = SkillsAdapter(skillProjects)
        }
    }
}
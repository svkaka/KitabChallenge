package com.ovrbach.kitabsawtichallenge.general.ui.work

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ovrbach.kitabsawtichallenge.common.entity.Project
import com.ovrbach.kitabsawtichallenge.general.R
import com.ovrbach.kitabsawtichallenge.general.ui.education.EducationProjects
import com.ovrbach.kitabsawtichallenge.general.ui.education.ProjectAdapter
import kotlinx.android.synthetic.main.item_company.view.*


class WorkAdapter : ListAdapter<CompanyProjects, WorkAdapter.MyHolder>(object : DiffUtil.ItemCallback<CompanyProjects>() {
    override fun areContentsTheSame(oldItem: CompanyProjects, newItem: CompanyProjects): Boolean =
            oldItem == newItem

    override fun areItemsTheSame(oldItem: CompanyProjects, newItem: CompanyProjects): Boolean =
            oldItem == newItem

}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder =
            WorkAdapter.MyHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
            )


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.bind(item)
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item_company_name = itemView.item_company_name
        val item_company_projects_recycler = itemView.item_company_projects_recycler

        fun bind(educationProject: CompanyProjects) {
            item_company_name.text = educationProject.company
            item_company_projects_recycler.apply {
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = ProjectAdapterCompany(educationProject.projects)
            }
        }

    }

}

class CompanyProjects(
        val projects: List<Project>,
        val company: String
)
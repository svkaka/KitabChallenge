package com.ovrbach.kitabsawtichallenge.general.ui.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ovrbach.kitabsawtichallenge.common.entity.Education
import com.ovrbach.kitabsawtichallenge.common.entity.Project
import com.ovrbach.kitabsawtichallenge.general.R
import kotlinx.android.synthetic.main.item_education.view.*

class EducationAdapter : ListAdapter<EducationProjects, EducationAdapter.MyHolder>(object : DiffUtil.ItemCallback<EducationProjects>() {
    override fun areContentsTheSame(oldItem: EducationProjects, newItem: EducationProjects): Boolean =
            oldItem == newItem

    override fun areItemsTheSame(oldItem: EducationProjects, newItem: EducationProjects): Boolean =
            oldItem == newItem

}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder =
            EducationAdapter.MyHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_education, parent, false)
            )


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.bind(item)
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item_company_date = itemView.item_company_date
        val item_company_recycler = itemView.item_company_recycler
        val item_company_school = itemView.item_company_school
        val item_company_title = itemView.item_company_title

        fun bind(educationProject: EducationProjects) {
            item_company_date.text = "${educationProject.education.startDate} - ${educationProject.education.endDate
                    ?: "now"}"
            item_company_school.text = educationProject.education.name
            item_company_title.text = "${educationProject.education.degree?:"-"}, ${educationProject.education.fieldOfStudy}"
            item_company_recycler.apply {
                layoutManager = LinearLayoutManager(itemView.context)
                adapter = ProjectAdapter(educationProject.projects)
            }
        }

    }

}

class EducationProjects(
        val projects: List<Project>,
        val education: Education
)

class CompanyProjects(
        val projects: List<Project>,
        val company: String
)
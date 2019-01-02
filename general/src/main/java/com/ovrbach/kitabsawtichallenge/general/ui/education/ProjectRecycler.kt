package com.ovrbach.kitabsawtichallenge.general.ui.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ovrbach.kitabsawtichallenge.common.entity.Project
import com.ovrbach.kitabsawtichallenge.general.R
import kotlinx.android.synthetic.main.item_project.view.*

class ProjectAdapter(val items: List<Project>) : RecyclerView.Adapter<ProjectAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder = MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = items[holder.adapterPosition]
        holder.bind(item)
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item_project_date = itemView.item_project_date
        val item_project_description = itemView.item_project_description
        val item_project_name = itemView.item_project_name
        val item_project_tech = itemView.item_project_tech

        fun bind(project: Project) {
            item_project_date.text = "${project.startDate} - ${project.endDate
                    ?: "now"}"
            item_project_description.text = project.description
            item_project_name.text = project.name
            item_project_tech.text = project.techUsed.joinToString { it }

        }
    }

}
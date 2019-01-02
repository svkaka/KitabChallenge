package com.ovrbach.kitabsawtichallenge.general.ui.skills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arasthel.spannedgridlayoutmanager.SpanLayoutParams
import com.arasthel.spannedgridlayoutmanager.SpanSize
import com.ovrbach.kitabsawtichallenge.general.R
import kotlinx.android.synthetic.main.item_skill.view.*

const val NUMBER_OF_COLUMNS = 12
const val NUMBER_OF_COLUMNS_MIN = 4
const val NUMBER_OF_COLUMNS_EXPAND = 7

class SkillsAdapter(val items: List<SkillProjects>) : RecyclerView.Adapter<SkillsAdapter.Holder>() {
    var clickedItem = -1

    init {
        setHasStableIds(true)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val item_lego_category_name = itemView.item_skills_name
        val item_adapter_content = itemView.item_adapter_content
        val item_lego_category_items = itemView.item_skills_items
        val item_lego_timeline_guideline = itemView.item_skills_timeline_guideline

        fun populateViewHolder(skill: SkillProjects) {

            item_lego_category_name.text = skill.skill

            val expanded = adapterPosition == clickedItem
            val width = if (expanded) NUMBER_OF_COLUMNS else NUMBER_OF_COLUMNS_MIN
            val height = if (expanded) NUMBER_OF_COLUMNS_EXPAND else NUMBER_OF_COLUMNS_MIN

            val spanSize = SpanSize(width, height)

            itemView.layoutParams = SpanLayoutParams(spanSize)

            item_lego_category_items.visibility = if (expanded) View.VISIBLE else View.GONE
            item_lego_timeline_guideline.setGuidelinePercent(if (expanded) 0.5f else 1f)
            if (expanded) {
                item_lego_category_items.text = skill.projectsNames.joinToString { it }
            }

            itemView.setOnClickListener {
                val previous = clickedItem

                clickedItem = if (adapterPosition == clickedItem) {
                    -1
                } else {
                    adapterPosition
                }
                if (previous != -1) {
                    notifyItemChanged(previous)
                }
                notifyItemChanged(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        return Holder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_skill,
                        parent,
                        false)
        )
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int =
            items.size


    override fun onBindViewHolder(holder: Holder, p1: Int) {
        val item = items[holder.adapterPosition]
        holder.populateViewHolder(item)
    }

}

class SkillProjects(
        val projectsNames: List<String>,
        val skill: String
)
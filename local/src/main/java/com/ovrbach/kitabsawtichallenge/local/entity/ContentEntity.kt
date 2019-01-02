package com.ovrbach.kitabsawtichallenge.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ovrbach.kitabsawtichallenge.common.entity.Content
import com.ovrbach.kitabsawtichallenge.common.entity.Education
import com.ovrbach.kitabsawtichallenge.common.entity.Project

@Entity(tableName = "content")
open class ContentEntity(
    version: String,
    overview: String,
    manifesto: String,
    @TypeConverters(EducationListTypeConverter::class)
    education: List<Education>,
    @TypeConverters(ProjectListTypeConverter::class)
    projects: List<Project>
) : Content(version, overview, manifesto, education, projects) {

    @PrimaryKey
    var id: Long = 0
}

fun Content.convertToContentEntity() =
    ContentEntity(
        version = version,
        overview = overview,
        manifesto = manifesto,
        education = education,
        projects = projects
    )


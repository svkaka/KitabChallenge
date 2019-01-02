package com.ovrbach.kitabsawtichallenge.local.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.ovrbach.kitabsawtichallenge.common.entity.Education
import com.ovrbach.kitabsawtichallenge.common.entity.Project
import java.util.*

class ProjectListTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun toListOfEducation(value: String?): List<Project>? {
        val listType = object : TypeToken<List<Project>>() {}.type
        return try {
            gson.fromJson<List<Project>>(value, listType)
        } catch (exception: JsonSyntaxException) {
            Collections.emptyList<Project>()
        }
    }

    @TypeConverter
    fun toString(value: List<Project>): String {
        return gson.toJson(value)
    }
}
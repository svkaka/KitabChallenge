package com.ovrbach.kitabsawtichallenge.local.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.ovrbach.kitabsawtichallenge.common.entity.Education
import java.util.*

class EducationListTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun toListOfEducation(value: String?): List<Education>? {
        val listType = object : TypeToken<List<Education>>() {}.type
        return try {
            gson.fromJson<List<Education>>(value, listType)
        } catch (exception: JsonSyntaxException) {
            Collections.emptyList<Education>()
        }
    }

    @TypeConverter
    fun toString(value: List<Education>): String {
        return gson.toJson(value)
    }
}
package com.ovrbach.kitabsawtichallenge.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ovrbach.kitabsawtichallenge.local.entity.ContentEntity
import com.ovrbach.kitabsawtichallenge.local.dao.ContentDao
import com.ovrbach.kitabsawtichallenge.local.entity.EducationListTypeConverter
import com.ovrbach.kitabsawtichallenge.local.entity.ProjectListTypeConverter

@Database(
    entities = [ContentEntity::class], version = 1, exportSchema = false
)
@TypeConverters(
    EducationListTypeConverter::class,
    ProjectListTypeConverter::class
)
abstract class ContentDbs : RoomDatabase() {

    companion object {
        private var INSTANCE: ContentDbs? = null
        private const val DATABASE_NAME = "dbs"

        fun getInstance(context: Context): ContentDbs {
            if (INSTANCE == null) {
                synchronized(ContentDbs::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ContentDbs::class.java, DATABASE_NAME
                        ).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }


    abstract fun contentDao(): ContentDao
}
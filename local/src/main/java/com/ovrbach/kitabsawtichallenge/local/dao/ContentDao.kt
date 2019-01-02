package com.ovrbach.kitabsawtichallenge.local.dao;

import androidx.room.Dao;
import androidx.room.Insert
import androidx.room.Query;
import com.ovrbach.kitabsawtichallenge.common.entity.Content
import com.ovrbach.kitabsawtichallenge.local.entity.ContentEntity

@Dao
abstract class ContentDao {
    @Query("SELECT * FROM content")
    abstract fun getContent(): ContentEntity?

    @Query("UPDATE content set version = :version, overview =:overview, manifesto=:manifesto WHERE id = 0")
    abstract fun updateOverview(version: Int, overview: String, manifesto: String)

    @Insert
    abstract fun insertContent(content: ContentEntity)

}
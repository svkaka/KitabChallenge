package com.ovrbach.kitabsawtichallenge.common.entity

open class Content(
    val version: String,
    val overview: String,
    val manifesto: String,
    val education: List<Education>,
    val projects: List<Project>
)

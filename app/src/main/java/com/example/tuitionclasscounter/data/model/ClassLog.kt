package com.example.tuitioncounter.data.model

import java.util.Date

data class ClassLog(
    val id: Int,
    val tuitionId: Int,
    val date: Date,
    val notes: String? = null
)

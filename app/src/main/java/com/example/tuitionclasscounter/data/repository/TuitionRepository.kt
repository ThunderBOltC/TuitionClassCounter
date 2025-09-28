package com.example.tuitioncounter.data.repository

import com.example.tuitioncounter.data.model.ClassLog
import com.example.tuitioncounter.data.model.Tuition
import java.util.*

object TuitionRepository {
    private val tuitions = mutableListOf<Tuition>()
    private val classLogs = mutableListOf<ClassLog>()

    fun getAllTuitions() = tuitions
    fun addTuition(tuition: Tuition) = tuitions.add(tuition)

    fun logClass(tuitionId: Int, notes: String? = null) {
        val tuition = tuitions.find { it.id == tuitionId } ?: return
        tuition.completedClasses++
        classLogs.add(ClassLog(classLogs.size + 1, tuitionId, Date(), notes))
    }

    fun getClassLogs(tuitionId: Int) =
        classLogs.filter { it.tuitionId == tuitionId }
}

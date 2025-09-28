package com.example.tuitioncounter.data.model

data class Tuition(
    val id: Int,
    val studentName: String,
    val location: String,
    val monthlyTarget: Int,
    val ratePerClass: Double,
    var completedClasses: Int = 0,
    var paymentReceived: Boolean = false
)

package com.example.tuitionclasscounter   // <- must match package

import androidx.compose.runtime.*
import com.example.tuitionclasscounter.ui.auth.LoginScreen
import com.example.tuitionclasscounter.ui.tuitions.TuitionListScreen
import com.example.tuitionclasscounter.ui.tuitions.AddTuitionScreen
import com.example.tuitionclasscounter.ui.logs.ClassLogScreen

@Composable
fun TuitionCounterApp() {
    var screen by remember { mutableStateOf("login") }
    var selectedTuitionId by remember { mutableStateOf<Int?>(null) }

    when (screen) {
        "login" -> LoginScreen { screen = "list" }
        "list" -> TuitionListScreen(
            onAddTuition = { screen = "add" },
            onViewLogs = { id -> selectedTuitionId = id; screen = "logs" }
        )
        "add" -> AddTuitionScreen { screen = "list" }
        "logs" -> selectedTuitionId?.let { id ->
            ClassLogScreen(tuitionId = id, onBack = { screen = "list" })
        } ?: run { screen = "list" } // fallback if null
    }
}

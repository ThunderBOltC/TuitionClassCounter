package com.example.tuitionclasscounter.ui.logs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tuitioncounter.data.repository.TuitionRepository

@Composable
fun ClassLogScreen(tuitionId: Int, onBack: () -> Unit) {
    val logs = TuitionRepository.getClassLogs(tuitionId)

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Class Logs", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = {
            TuitionRepository.logClass(tuitionId, "Regular class")
        }, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Text("Log New Class")
        }

        LazyColumn {
            items(logs.size) { index ->
                val log = logs[index]
                Card(Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Date: ${log.date}")
                        log.notes?.let { Text("Notes: $it") }
                    }
                }
            }
        }

        Button(onClick = onBack, modifier = Modifier.padding(top = 16.dp)) {
            Text("Back")
        }
    }
}

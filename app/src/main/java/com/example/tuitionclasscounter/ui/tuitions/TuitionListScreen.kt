package com.example.tuitionclasscounter.ui.tuitions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tuitioncounter.data.model.Tuition
import com.example.tuitioncounter.data.repository.TuitionRepository

@Composable
fun TuitionListScreen(onAddTuition: () -> Unit, onViewLogs: (Int) -> Unit) {
    val tuitions = TuitionRepository.getAllTuitions()

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("My Tuitions", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {
            items(tuitions.size) { index ->
                val tuition = tuitions[index]
                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp), // Corrected line
                    onClick = { onViewLogs(tuition.id) }
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(tuition.studentName, style = MaterialTheme.typography.titleLarge)
                        Text("Completed: ${tuition.completedClasses}/${tuition.monthlyTarget}")
                        Text("Rate: ${tuition.ratePerClass} BDT")
                    }
                }
            }
        }

        Button(onClick = onAddTuition, modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
            Text("Add Tuition")
        }
    }
}

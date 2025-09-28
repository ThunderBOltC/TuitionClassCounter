package com.example.tuitionclasscounter.ui.tuitions

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tuitioncounter.data.model.Tuition
import com.example.tuitioncounter.data.repository.TuitionRepository

@Composable
fun AddTuitionScreen(onSave: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var target by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Student Name") })
        OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("Location") })
        OutlinedTextField(value = target, onValueChange = { target = it }, label = { Text("Monthly Target") })
        OutlinedTextField(value = salary, onValueChange = { salary = it }, label = { Text("Rate Per Class") })

        Button(onClick = {
            TuitionRepository.addTuition(
                Tuition(
                    id = TuitionRepository.getAllTuitions().size + 1,
                    studentName = name,
                    location = location,
                    monthlyTarget = target.toIntOrNull() ?: 0,
                    ratePerClass = salary.toDoubleOrNull() ?: 0.0
                )
            )
            onSave()
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Save Tuition")
        }
    }
}

package com.example.tuitionclasscounter   // <- must match YOUR package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tuitionclasscounter.ui.theme.TutionClassCounterTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutionClassCounterTheme {   // <- use auto-generated theme
                TuitionCounterApp()
            }
        }
    }
}


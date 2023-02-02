package com.example.jackofallapp.featureShowGrob.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.jackofallapp.featureShowGrob.presentation.grobbies.GrobbiesViewModel
import com.example.jackofallapp.featureShowGrob.presentation.grobbies.ShowGrobbies
import com.example.jackofallapp.ui.theme.JackOfAllAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JackOfAllAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ShowGrobbies(GrobbiesViewModel())
                }
            }
        }
    }
}
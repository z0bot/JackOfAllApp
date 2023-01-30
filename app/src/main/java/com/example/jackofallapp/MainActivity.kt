package com.example.jackofallapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jackofallapp.ui.theme.JackOfAllAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JackOfAllAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val grobbies = mutableListOf(
                        Grobby("Grobby Forlop", 3),
                        Grobby("Grobby Mangorf", 3),
                        Grobby("Grobby Flurf", 3),
                        Grobby("Grobby Cado", 3),
                        Grobby("Grobby Beef", 3),
                        Grobby("Grobby Monosaccharide", 3),
                        Grobby("Grobby Shiggle", 2),
                    )
                    ShowGrobbies(grobbies)
                }
            }
        }
    }
}
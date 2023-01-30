package com.example.jackofallapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ShowGrobbies(grobbies: List<Grobby>){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(grobbies){ grobby ->
               GrobbyCard(grobby.name, grobby.age)
            }
        }
    }
}
package com.example.jackofallapp.featureShowGrob.presentation.grobbies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jackofallapp.featureShowGrob.presentation.grobbies.components.GrobbyCard
import com.example.jackofallapp.featureShowGrob.domain.models.Grobby


@Composable
fun ShowGrobbies(viewModel : GrobbiesViewModel){
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
            items(viewModel.grobbyList){ grobby ->
               GrobbyCard(grobby.name, grobby.age)
            }
        }
    }
}
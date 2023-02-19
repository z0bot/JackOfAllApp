package com.example.jackofallapp.featureShowGrob.presentation.grobbies

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jackofallapp.featureShowGrob.presentation.grobbies.components.GrobbyCard
import com.example.jackofallapp.featureShowGrob.domain.models.Grobby
import com.example.jackofallapp.featureShowGrob.presentation.grobbies.components.AddGrobby

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowGrobbies(viewModel: GrobbiesViewModel) {
    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.showDialog = true },
                shape = RoundedCornerShape(16.dp)
            )
            {
                Text(text = "+")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            AddGrobby(
                openDialog = viewModel.showDialog,
                onAddGrobby = { grobby ->
                    viewModel.onAddGrobby(grobby)
                },
                onConfirm = { viewModel.onDialogConfirm() },
                onDismiss = { viewModel.onDialogDismiss() }
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(viewModel.grobbyList) { grobby ->
                    GrobbyCard(grobby.name, grobby.age)
                }
            }
        }
    }
}
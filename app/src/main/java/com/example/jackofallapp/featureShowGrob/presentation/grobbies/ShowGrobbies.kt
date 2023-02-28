package com.example.jackofallapp.featureShowGrob.presentation.grobbies

import android.graphics.drawable.Icon
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jackofallapp.featureShowGrob.presentation.grobbies.components.GrobbyCard
import com.example.jackofallapp.featureShowGrob.domain.models.Grobby
import com.example.jackofallapp.featureShowGrob.presentation.grobbies.components.AddGrobby

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
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
                items( viewModel.grobbyList
                ) { grobby ->
                    val currentItem by rememberUpdatedState(grobby)
                    val dismissState = rememberDismissState(
                        confirmStateChange = {
                            viewModel.onDeleteGrobby(grobby)
                            true
                        }
                    )
                    SwipeToDismiss(
                        state = dismissState,
                        background = {
                            val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
                            val color by animateColorAsState(
                                targetValue = when (dismissState.targetValue) {
                                    DismissValue.Default -> Color.LightGray
                                    DismissValue.DismissedToEnd -> Color.Green
                                    DismissValue.DismissedToStart -> Color.Red
                                }
                            )


                        },
                        directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
                        dismissContent = {
                            GrobbyCard(name = grobby.name , age = grobby.age )
                        }
                    )
                }
            }
        }
    }
}
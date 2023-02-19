package com.example.jackofallapp.featureShowGrob.presentation.grobbies.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.example.jackofallapp.featureShowGrob.domain.models.Grobby

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGrobby(
    openDialog: Boolean,
    onAddGrobby: (Grobby) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (openDialog) {
        val grobbyName = remember { mutableStateOf("") }
        val grobbyAge = remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { onDismiss.invoke() },
            confirmButton = {
                TextButton(onClick = {
                    if (grobbyName.value.isNotEmpty() && grobbyAge.value.isNotEmpty()) {
                        var grobby = Grobby(grobbyName.value, grobbyAge.value.toInt())
                        onAddGrobby.invoke(grobby)
                        onConfirm.invoke()
                    }
                }) {
                    Text(text = "Add Grobby")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss.invoke() }) {
                    Text(text = "Cancel")
                }
            },
            title = {
                Text(text = "New Grobby")
            },
            text = {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = grobbyName.value,
                        onValueChange = { grobbyName.value = it },
                        label = {
                            Text(text = "Name")
                        }
                    )
                    OutlinedTextField(
                        value = grobbyAge.value,
                        onValueChange = { grobbyAge.value = it },
                        label = {
                            Text(text = "Age")
                        }
                    )
                }
            })
    }
}

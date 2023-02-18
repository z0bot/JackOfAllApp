package com.example.jackofallapp.featureShowGrob.presentation.grobbies.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun AddGrobby(openDialog: Boolean){
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = {}) {
                Text(text = "Add Grobby")
            }
        },
        dismissButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Cancel")
            }
        },
        title = {
            Text(text = "New Grobby")
        },
        text = {
            Text(text = "Name")
            TextField(value = , onValueChange = )
            Text(text = "Age")
        })
}

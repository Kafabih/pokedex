package com.svck.mobile.pokedexapp.utils

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog

@Composable
fun TriggerProgressBar(){
    Dialog(onDismissRequest = { }) {
        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
    }
}
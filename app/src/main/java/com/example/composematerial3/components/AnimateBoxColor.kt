package com.example.composematerial3.components

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AnimateBoxColor(firstColor: Color, secondColor: Color) {

    val context = LocalContext.current
    var colorState by remember { mutableStateOf(true) }
    val color by animateColorAsState(if (colorState) firstColor else secondColor)

    Box(
        Modifier
            .size(128.dp)
            .background(color)
    )

    Spacer(Modifier.height(16.dp))

    Button(
        onClick = {
            colorState = !colorState
            Toast.makeText(
                context,
                "Button clicked!",
                Toast.LENGTH_SHORT
            ).show()
        },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(text = "Change color", color = MaterialTheme.colorScheme.primary)
    }
}
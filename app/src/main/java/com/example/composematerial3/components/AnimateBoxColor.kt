package com.example.composematerial3.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateBoxColor(firstColor: Color, secondColor: Color) {
//    https://medium.com/androiddevelopers/under-the-hood-of-jetpack-compose-part-2-of-2-37b2c20c6cdd
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
        },
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(text = "Change color")
    }
}
package com.example.composematerial3.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val AppLightColorScheme = lightColorScheme(
    primary = Purple500,
    surfaceVariant = Purple700,
    secondary = Teal200
)

private val AppDarkColorScheme = darkColorScheme(
    primary = Purple200,
    surfaceVariant = Purple700,
    secondary = Teal200
)

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun AppTheme(
    dark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val dynamic = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colorScheme = if (dynamic) {
        val context = LocalContext.current
        if (dark) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (dark) AppDarkColorScheme else AppLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
        // material2 has shape, in material3 hasn't been implemented
    )
}

//@Composable
//fun AppTheme2() {
//    androidx.compose.material.MaterialTheme()
//}
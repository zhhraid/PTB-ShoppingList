// File: app/src/main/java/com/example/shoppinglist/ui/theme/Theme.kt

package com.example.shoppinglist.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Menggunakan skema warna BIRU yang sudah ada di Color.kt
private val DarkColorScheme = darkColorScheme(
    primary = BlueDarkPrimaryContainer,
    onPrimary = BlueDarkOnPrimaryContainer,
    primaryContainer = BlueDarkPrimaryContainer,
    onPrimaryContainer = BlueDarkOnPrimaryContainer,
    secondary = BlueDarkSecondaryContainer,
    onSecondaryContainer = BlueDarkOnSecondaryContainer,
    background = BlueDarkBackground,
    onBackground = BlueDarkOnBackground,
    surface = BlueSurfaceDark,
    onSurface = BlueOnSurfaceDark
)

// Menggunakan skema warna BIRU yang sudah ada di Color.kt
private val LightColorScheme = lightColorScheme(
    primary = BlueLight,
    onPrimary = BlueOn,
    primaryContainer = BluePrimaryContainer,
    onPrimaryContainer = BlueOnPrimaryContainer,
    secondary = BlueSecondary,
    onSecondaryContainer = BlueOnSecondaryContainer,
    background = BlueBackground,
    onBackground = BlueOnBackground,
    surface = BlueSurface,
    onSurface = BlueOnSurface
)

@Composable
fun ShoppingListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
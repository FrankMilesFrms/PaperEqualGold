/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(Theme.kt) is part of E纸千金.
 *
 * E纸千金 is free software:
 * you can redistribute it and/or modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * E纸千金 is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with E纸千金.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package org.frms.paper.equal.gold.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
	primary = Purple80, secondary = PurpleGrey80, tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
	primary = PurpleMain, secondary = PurpleGrey40, tertiary = Pink40

)

@Composable
fun EPaperTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),		// Dynamic color is available on Android 12+
	dynamicColor: Boolean = true,
	showSystemBar: Boolean,
	content: @Composable () -> Unit
)
{
	val colorScheme = LightColorScheme //		when
	//	{
	//		dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
	//		{
	//			val context = LocalContext.current
	//			if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
	//		}
	//		darkTheme                                                      -> DarkColorScheme
	//		else                                                           -> LightColorScheme
	//	}
	//	val view = LocalView.current
	//	if (!view.isInEditMode)
	//	{
	//		SideEffect {
	//			(view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
	//			ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
	//		}
	//	}

	MaterialTheme(
		colorScheme = colorScheme, typography = Typography
	) {
		if (showSystemBar.not())
		{
			val systemUiController = rememberSystemUiController()
			val isDark = isSystemInDarkTheme()

			SideEffect {
				systemUiController.setStatusBarColor(
					Color.Transparent, darkIcons = !isDark
				)
			}
		}		// other composes
		content()
	}
}
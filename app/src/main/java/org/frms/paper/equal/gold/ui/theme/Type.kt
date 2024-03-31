/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(Type.kt) is part of E纸千金.
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

import androidx.compose.material3.Typography
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.frms.paper.equal.gold.R


val NormalFont = FontFamily(
	Font(R.font.alibabapuhuti, FontWeight.Light), Font(R.font.alibabapuhuti, FontWeight.Normal), Font(R.font.alibabapuhuiti_bold, FontWeight.Bold)
)

val h1 = TextStyle(
	fontSize = 18.sp, fontFamily = NormalFont
)

val smallFont = TextStyle(
	fontSize = 10.sp, fontFamily = NormalFont, lineHeight = 15.sp
)

val bodyFont = TextStyle(
	fontSize = 15.sp, fontFamily = NormalFont, lineHeight = 25.sp
)

val bodyFont1 = TextStyle(
	fontSize = 18.sp, fontFamily = NormalFont, lineHeight = 34.sp
)

// Set of Material typography styles to start with
val Typography = Typography(
	bodyLarge = TextStyle(
		fontFamily = NormalFont, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.5.sp
	),
)
/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(ComposeUtils.kt) is part of E纸千金.
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
package org.frms.paper.equal.gold.composes

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp

/**
 * 获取加载条刷
 * @return Brush
 */
@Composable
fun getBackgroundBrush(): Brush
{
	val shimmerColors = listOf(
		Color.LightGray.copy(alpha = 0.6f),
		Color.LightGray.copy(alpha = 0.2f),
		Color.LightGray.copy(alpha = 0.6f),
	)


	val transition = rememberInfiniteTransition()
	val translateAnimation = transition.animateFloat(
		initialValue = 0f, targetValue = 1000f, animationSpec = infiniteRepeatable(
			animation = tween(
				durationMillis = 1000, easing = FastOutSlowInEasing
			), repeatMode = RepeatMode.Reverse
		)
	)

	return Brush.linearGradient(
		colors = shimmerColors, start = Offset.Zero, end = Offset(
			x = translateAnimation.value, y = translateAnimation.value
		)
	)

}

@Composable
fun ShapeImage(
	modifier: Modifier = Modifier,
	size: Dp,
	shape: Shape = CircleShape,
	painter: Painter,
	contentScale: ContentScale = ContentScale.Fit,
	contentDescription: String,
	onClick: () -> Unit = {}
)
{
	Surface(
		modifier = modifier
			.size(size)
			.clickable { onClick() },
		shape = shape,
	) {
		Image(
			painter = painter,
			contentDescription = contentDescription,
			contentScale = contentScale,
		)
	}
}

// 长按Modifier
fun Modifier.longClick(onLongClick: (Offset) -> Unit): Modifier =
	pointerInput(this) {
		detectTapGestures(
			onLongPress = onLongClick
		)
	}

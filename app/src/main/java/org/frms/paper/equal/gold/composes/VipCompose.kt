/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(VipCompose.kt) is part of E纸千金.
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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.ui.theme.Pink180
import org.frms.paper.equal.gold.ui.theme.Pink40
import org.frms.paper.equal.gold.ui.theme.PurpleMain
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/24 下午 11:53
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun VipPreview()
{

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayColumn(
	title: String,
	message: String,
	painter: Painter
)
{
	Surface(
		modifier = Modifier
			.fillMaxWidth()
			.height(100.dp)
			.padding(
				start = 10.dp, end = 10.dp
			), shadowElevation = 8.dp, shape = RoundedCornerShape(10.dp)
	) {
		Row(
			modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
		) {
			Image(
				painter = painter, contentDescription = null, modifier = Modifier
					.padding(10.dp)
					.weight(1.2f)
			)

			Column(modifier = Modifier.weight(5f)) {
				Text(text = title)
				Text(text = message)
			}

			RadioButton(selected = false, modifier = Modifier.weight(1f), onClick = { /*TODO*/ })
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectVipCard(
	modifier: Modifier = Modifier,
	size: Int = 100,
	selected: Boolean = false,
	info: String,
	price: Int
)
{
	OutlinedCard(
		modifier = modifier.size(size.dp), border = if (selected) BorderStroke(1.dp, Pink180) else CardDefaults.outlinedCardBorder()
	) {
		Column(
			verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
		) {
			Text(text = info)
			Text(text = "￥$price")
		}
	}
}
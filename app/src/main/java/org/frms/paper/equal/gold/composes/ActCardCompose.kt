/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(ActCardCompose.kt) is part of E纸千金.
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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *主界面活动卡片
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/05 上午 11:56
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTopBar(text: String)
{
	TopAppBar(
		title = {
			Text(
				text = text, style = h1, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
			)
		},
		colors = TopAppBarDefaults.smallTopAppBarColors(
			containerColor = backgroundGray
		),
		modifier = Modifier.statusBarsPadding(),
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActCard(
	id: Int,
	authorImage: Painter,
	header: String,
	subHead: String,
	image: Painter,
	title: String,
	message: String,

	onClickIcon: () -> Unit = {},
	onClickCard: (Int) -> Unit = {}
)
{
	OutlinedCard(
		onClick = { onClickCard(id) }, modifier = Modifier
			.fillMaxWidth()
			.height(IntrinsicSize.Min)
			.padding(
				start = 8.dp, end = 8.dp, bottom = 18.dp
			)
	) {
		Column(Modifier.fillMaxSize()) {
			Spacer(modifier = Modifier.height(10.dp))

			Row(
				modifier = Modifier
					.fillMaxWidth()
					.height(60.dp), verticalAlignment = Alignment.CenterVertically
			) {

				ShapeImage(
					modifier = Modifier.padding(start = 10.dp, end = 10.dp), size = 60.dp, painter = authorImage, contentDescription = stringResource(id = R.string.author), onClick = onClickIcon
				)

				Row(verticalAlignment = Alignment.Top) {
					Column(
						modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceEvenly
					) {
						Text(
							text = header,
							style = h1,
							fontWeight = FontWeight.Bold,
						)
						Text(
							text = subHead, style = h1, fontWeight = FontWeight.Light, fontSize = 14.sp
						)
					}
				}
			}
			Spacer(modifier = Modifier.height(10.dp))
			Image(
				painter = image, contentDescription = stringResource(id = R.string.shop_image), modifier = Modifier
					.fillMaxWidth()
					.aspectRatio(16f / 9), contentScale = ContentScale.Crop
			)
			Spacer(modifier = Modifier.height(10.dp))
			Text(
				text = title, style = h1, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 5.dp)
			)
			Spacer(modifier = Modifier.height(5.dp))
			Text(
				text = message, style = h1, fontWeight = FontWeight.Light, fontSize = 14.sp, maxLines = 3, modifier = Modifier.padding(start = 5.dp)
			)
			Spacer(modifier = Modifier.height(20.dp))
		}

	}
}

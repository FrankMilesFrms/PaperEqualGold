/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(UserCompose.kt) is part of E纸千金.
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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.activities.composable.IconActionPainter
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 * 用户中心次级组件
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/25 下午 11:52
 */

@Composable
fun UserSettingList(
	painter: Painter? = null,
	name: String,
	onClick: () -> Unit = {}
)
{
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(
				start = 15.dp, end = 15.dp
			)
			.clickable { onClick() }, horizontalAlignment = Alignment.CenterHorizontally
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.height(40.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
		) {
			Row(
				modifier = Modifier.padding(start = 10.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically
			) {
				Icon(
					imageVector = Icons.Filled.Settings, contentDescription = null, modifier = Modifier.padding(end = 8.dp)
				)
				Text(
					text = name, style = h1, fontWeight = FontWeight.Light
				)
			}

			Icon(
				imageVector = Icons.Filled.ArrowForward, contentDescription = null
			)
		}
		Divider(
			modifier = Modifier
				.fillMaxWidth()
				.background(Color(219, 219, 219)), thickness = 0.5.dp
		)
	}
}

/**
 * 用户信息卡片
 * @param painter Painter
 * @param name String
 * @param phone String
 * @param iconClick Function0<Unit>
 */
@Composable
fun UserInformation(
	painter: Painter,
	name: String,
	phone: String,
	iconClick: () -> Unit = {},

	)
{
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(100.dp), verticalAlignment = Alignment.CenterVertically
	) {
		ShapeImage(
			modifier = Modifier
				.padding(10.dp)
				.clickable { iconClick() }, size = 85.dp, painter = painter, contentDescription = stringResource(id = R.string.act_user), contentScale = ContentScale.Crop
		)

		Column(
			modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceEvenly
		) {
			Text(
				text = name, style = h1, fontSize = 20.sp
			)

			Row(
				horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
			) {
				Icon(
					imageVector = Icons.Filled.Phone, contentDescription = stringResource(id = R.string.phone)
				)

				Text(
					text = "+86 $phone", style = h1, fontSize = 20.sp
				)
			}
		}
	}
}

/**
 * 个人中心的销售卡片
 * @param iconAction1 IconActionPainter
 * @param iconAction2 IconActionPainter
 * @param iconAction3 IconActionPainter
 * @param title String
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SellerCard(
	iconAction1: IconActionPainter,
	iconAction2: IconActionPainter,
	iconAction3: IconActionPainter,

	title: String
)
{
	OutlinedCard(
		shape = RoundedCornerShape(18.dp), modifier = Modifier
			.fillMaxWidth()
			.height(180.dp)
			.padding(10.dp), colors = CardDefaults.outlinedCardColors(
			containerColor = backgroundGray
		)
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(15.dp), verticalArrangement = Arrangement.Top
		) {
			Text(
				text = title, style = h1, fontSize = 20.sp, fontWeight = FontWeight.Bold
			)

			Column(
				modifier = Modifier.fillMaxSize()
			) {
				Row(
					Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround
				) {

					Column(
						verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
					) {
						IconButton(onClick = iconAction1.onClick) {
							Icon(
								painter = iconAction1.painter, contentDescription = iconAction2.text
							)
						}

						Text(
							text = iconAction1.text, modifier = Modifier, textAlign = TextAlign.Center, style = h1
						)
					}

					Column(
						verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
					) {
						IconButton(onClick = iconAction2.onClick) {
							Icon(
								painter = iconAction2.painter, contentDescription = iconAction2.text
							)
						}

						Text(
							text = iconAction2.text, modifier = Modifier, textAlign = TextAlign.Center, style = h1
						)
					}

					Column(
						verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
					) {
						IconButton(onClick = iconAction3.onClick) {
							Icon(
								painter = iconAction3.painter, contentDescription = iconAction3.text
							)
						}

						Text(
							text = iconAction3.text, modifier = Modifier, textAlign = TextAlign.Center, style = h1
						)
					}
				}
			}
		}
	}
}

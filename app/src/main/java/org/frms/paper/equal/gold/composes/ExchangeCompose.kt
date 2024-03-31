/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(ExchangeCompose.kt) is part of E纸千金.
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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.ui.theme.NormalFont
import org.frms.paper.equal.gold.ui.theme.Purple40
import org.frms.paper.equal.gold.ui.theme.bodyFont
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *兑换中心
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/14 下午 06:15
 */

@Composable
fun ExchangeCard(
	shopId: Int,
	height: Int = 150,
	isLoading: Boolean = true,
	shopName: String = "最后的生还者",
	painter: Painter,
	nowPrice: Int = 144,
	brush: Brush? = null,
	onClick: (Int) -> Unit = {}
)
{
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.height(height = height.dp)
			.padding(
				top = 5.dp, start = 8.dp, end = 8.dp, bottom = 5.dp
			)
			.clickable {
				onClick(shopId)
			}, colors = CardDefaults.cardColors(
			containerColor = Color.White
		)
	) {
		Row(
			modifier = Modifier
				.fillMaxSize()
				.padding(5.dp)
		) {
			if (isLoading && brush != null)
			{
				Spacer(
					modifier = Modifier
						.fillMaxSize()
						.weight(0.8f)
						.clip(
							RoundedCornerShape(
								topStart = 12.dp, bottomStart = 12.dp
							)
						)
						.background(brush)
				)

				Column(modifier = Modifier.weight(1f)) {
					repeat(5) {
						Spacer(
							modifier = Modifier
								.fillMaxWidth()
								.weight(1f)
								.padding(3.dp)
								.background(brush)
						)
					}
				}
			} else
			{
				Image(
					painter = painter,
					contentDescription = stringResource(id = R.string.shop_image),
					modifier = Modifier
						.size(height.dp)
						.clip(
							RoundedCornerShape(
								topStart = 12.dp, bottomStart = 12.dp
							)
						),
					contentScale = ContentScale.Crop,
				)

				Spacer(modifier = Modifier.width(5.dp))

				Column(
					modifier = Modifier
						.fillMaxHeight()
						.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
				) {
					Text(
						text = shopName, modifier = Modifier
							.fillMaxWidth()
							.padding(top = 5.dp),							// todo Dark Theme
						color = Color.Black
					)

					Column(
						modifier = Modifier
							.fillMaxWidth()
							.padding(5.dp), horizontalAlignment = Alignment.End
					) {

						Text(
							text = "$nowPrice 积分", style = TextStyle(
								textAlign = TextAlign.End
							), fontSize = 20.sp, fontStyle = h1.fontStyle, modifier = Modifier.fillMaxWidth(),								// todo Dark Theme
							color = Color.Black
						)

						//						Text(
						//								text = "兑换",
						//								style = bodyFont,
						//								fontSize = 15.sp,
						//								fontStyle = h1.fontStyle,
						//								modifier = Modifier
						//										.clip(RoundedCornerShape(20.dp))
						//										.background(Purple40)
						//										.padding(start =10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
						//										.clickable {
						//
						//										},
						//								// todo Dark Theme
						//								color = Color.White
						//						)
					}

				}
			}
		}
	}
}
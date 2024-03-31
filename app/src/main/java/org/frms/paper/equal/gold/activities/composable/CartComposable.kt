/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(CartComposable.kt) is part of E纸千金.
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
package org.frms.paper.equal.gold.activities.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.windowInsetsStartWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.CartCad
import org.frms.paper.equal.gold.composes.NormalBackTopBar
import org.frms.paper.equal.gold.datas.shopMessageList
import org.frms.paper.equal.gold.datas.shopPainterList
import org.frms.paper.equal.gold.datas.shopPrice
import org.frms.paper.equal.gold.ui.theme.Purple40
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.bodyFont
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *购物车
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/14 下午 10:00
 */
@Preview
@Composable
fun CartPreview(onClickBack: () -> Unit = {})
{
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray), verticalArrangement = Arrangement.SpaceBetween
	) {


		Column(
			modifier = Modifier.fillMaxWidth()
		) {
			NormalBackTopBar(title = "购物车", onClickBack = onClickBack)

			Column(
				modifier = Modifier
					.fillMaxWidth()
					.verticalScroll(rememberScrollState())
					.padding(
						start = 8.dp, end = 8.dp
					)
			) {				// todo user - buy list
				CartCad(
					shopId = 1, painter = painterResource(id = shopPainterList[0][0]), shopName = shopMessageList[0].first, nowPrice = shopPrice[0].first
				)

				Spacer(modifier = Modifier.height(5.dp))

				Text(
					text = "到底了~", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
				)
			}


		}

		Column(modifier = Modifier.fillMaxWidth()) {
			Row(
				Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
			) {
				Row(verticalAlignment = Alignment.CenterVertically) {
					Checkbox(checked = false, onCheckedChange = {})

					Text(text = "全选  合计：0￥")
				}


				Text(text = "购买", style = bodyFont, fontSize = 15.sp, fontStyle = h1.fontStyle, modifier = Modifier
					.clickable {

					}
					.clip(RoundedCornerShape(20.dp))
					.background(Purple40)
					.padding(
						start = 18.dp, end = 18.dp, top = 5.dp, bottom = 5.dp
					),						// todo Dark Theme
				     color = Color.White)
			}
			Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
		}
	}
}
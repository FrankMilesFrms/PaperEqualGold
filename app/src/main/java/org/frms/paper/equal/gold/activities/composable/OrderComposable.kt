/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(OrderComposable.kt) is part of E纸千金.
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.BuyShopCard
import org.frms.paper.equal.gold.datas.shopMessageList
import org.frms.paper.equal.gold.datas.shopPrice
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 * 订单界面
 * @param innerPadding PaddingValues
 * @param onClickShop Function1<Int, Unit>
 */
@Composable
fun OrderComposable(innerPadding: PaddingValues)
{
	LazyColumn(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
			.statusBarsPadding(), contentPadding = innerPadding
	) {
		item {
			BuyShopCard(
				shopId = 0, painter = painterResource(id = R.drawable.t_s_1), nowPrice = shopPrice[0].second, shopName = shopMessageList[0].first
			)
		}
		item {
			Text(text = "到底了~", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
		}
	}
}
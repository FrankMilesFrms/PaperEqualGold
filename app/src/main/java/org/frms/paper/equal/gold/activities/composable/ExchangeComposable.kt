/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(ExchangeComposable.kt) is part of E纸千金.
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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.ExchangeCard
import org.frms.paper.equal.gold.composes.HelpCenterCard
import org.frms.paper.equal.gold.composes.NormalBackTopBar
import org.frms.paper.equal.gold.datas.exchangeNameList
import org.frms.paper.equal.gold.datas.exchangePainterList
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 *todo 兑换中心
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/14 下午 06:16
 */
@Preview
@Composable
fun ExchangeComposable(onClickBack: () -> Unit = {})
{
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
	) {
		NormalBackTopBar(title = "兑换中心", onClickBack = onClickBack)

		Row(
			Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				painter = painterResource(id = R.drawable.exchange_icon), modifier = Modifier.size(30.dp), contentDescription = null //todo
			)

			Text(text = "积分余额：0")
			Spacer(modifier = Modifier.width(8.dp))
		}

		LazyColumn(
			modifier = Modifier
				.fillMaxWidth()
				.padding(
					start = 8.dp, end = 8.dp
				)
		) {
			items(4) {

				ExchangeCard(
					shopId = 1, painter = painterResource(id = exchangePainterList[it]), shopName = exchangeNameList[it].first, nowPrice = exchangeNameList[it].second
				)

				Spacer(modifier = Modifier.height(5.dp))
			}
		}
	}
}
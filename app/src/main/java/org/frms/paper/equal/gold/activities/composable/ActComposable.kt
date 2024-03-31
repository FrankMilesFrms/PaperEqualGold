/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(ActComposable.kt) is part of E纸千金.
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.ActCard
import org.frms.paper.equal.gold.datas.actPainter
import org.frms.paper.equal.gold.datas.newsMessage
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 * 活动界面
 * @param innerPadding PaddingValues
 * @param onClickShop Function1<Int, Unit>
 */
@Composable
fun ActComposable(
	innerPadding: PaddingValues,
	onClickCard: (Int) -> Unit
)
{
	LazyColumn(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
			.statusBarsPadding(), contentPadding = innerPadding
	) {
		items(newsMessage.size) {
			ActCard(
				it, authorImage = painterResource(id = R.drawable.hader), header = "管理员", subHead = "更多优惠，请关注公众号“E纸千金”", image = painterResource(id = actPainter[it]), title = newsMessage[it].first, message = newsMessage[it].second, onClickCard = onClickCard
			)
		}
	}
}
/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(BuyComposable.kt) is part of E纸千金.
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

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.activities.CenterActivity
import org.frms.paper.equal.gold.activities.ShopInfoActivity
import org.frms.paper.equal.gold.composes.ShopCard
import org.frms.paper.equal.gold.composes.getBackgroundBrush
import org.frms.paper.equal.gold.datas.INTENT_SHOP_MESSAGE
import org.frms.paper.equal.gold.datas.shopMessageList
import org.frms.paper.equal.gold.datas.shopPainterList
import org.frms.paper.equal.gold.datas.shopPrice
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 * 购买界面
 * @param innerPadding PaddingValues
 */
@Composable
fun BuyComposable(
	innerPadding: PaddingValues,
	activity: CenterActivity
)
{
	val brush = getBackgroundBrush()

	LazyColumn(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
			.statusBarsPadding(),
		contentPadding = innerPadding,
	) {		// todo  购买界面
		items(7) {
			ShopCard(shopId = it, isLoading = false, brush = brush, painter = painterResource(id = shopPainterList[it][0]), shopName = shopMessageList[it].first, rawPrice = shopPrice[it].first, nowPrice = shopPrice[it].second, onClick = {
				activity.startActivity(Intent(activity, ShopInfoActivity::class.java).apply {
					putExtra(INTENT_SHOP_MESSAGE, it)
				})
			})
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyTopBar(
	text: String,
	imageVector: ImageVector = Icons.Filled.Search,
	contentDescription: String = "",
	onClickIcon: () -> Unit = {}
)
{
	TopAppBar(
		title = {
			Text(
				text = text, style = h1
			)
		},
		actions = {
			IconButton(onClick = onClickIcon) {
				Icon(
					imageVector = imageVector, contentDescription = contentDescription
				)
			}
		},
		colors = TopAppBarDefaults.smallTopAppBarColors(
			containerColor = backgroundGray
		),
		modifier = Modifier.statusBarsPadding(),
	)
}
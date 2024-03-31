/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(ShopInfoActivity.kt) is part of E纸千金.
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
package org.frms.paper.equal.gold.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.NormalBackTopBar
import org.frms.paper.equal.gold.datas.INTENT_SHOP_MESSAGE
import org.frms.paper.equal.gold.datas.IconData
import org.frms.paper.equal.gold.datas.shopMessageList
import org.frms.paper.equal.gold.datas.shopPainterList
import org.frms.paper.equal.gold.datas.shopPrice
import org.frms.paper.equal.gold.ui.theme.EPaperTheme
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 *商品详细活动页
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/04 下午 09:25
 */
class ShopInfoActivity : ComponentActivity()
{
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		WindowCompat.setDecorFitsSystemWindows(window, false)
		val id = intent.getIntExtra(INTENT_SHOP_MESSAGE, 0)

		setContent {
			EPaperTheme(showSystemBar = false) {

				Surface(
					modifier = Modifier.fillMaxSize(), color = backgroundGray
				) {
					Scaffold(topBar = {
						NormalBackTopBar(
							stringResource(id = R.string.act_buy)
						)
					}, bottomBar = {
						Column(modifier = Modifier.fillMaxWidth()) {
							ShopBottomBar()
							Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
						}
					}) {						// 配合此来沉浸
						Column(
							modifier = Modifier
								.fillMaxSize()
								.background(backgroundGray)
								.padding(it)
								.verticalScroll(rememberScrollState())
						) {
							PagerOne(auto = true, autoTime = 2500, arrayListOf<IconData>().apply {										// todo test data of SHOP MESSAGE.
								repeat(shopPainterList[id].size) { count ->
									add(
										IconData(
											"", shopPainterList[id][count], R.string.app_name
										)
									)
								}
							})

							ShopPriceInfo(
								modifier = Modifier, shopRawPrice = shopPrice[id].first, shopNowPrice = shopPrice[id].second, discountMessage = "折扣截止至明天", shopName = shopMessageList[id].first, shopMessage = shopMessageList[id].second
							)

						}

					}
				}
			}
		}
	}
}
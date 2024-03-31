/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(TestActivity.kt) is part of E纸千金.
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

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.frms.paper.equal.gold.MainActivity
import org.frms.paper.equal.gold.activities.composable.BuyTopBar
import org.frms.paper.equal.gold.activities.composable.CartPreview
import org.frms.paper.equal.gold.activities.composable.DonateComposablePreview
import org.frms.paper.equal.gold.activities.composable.ExchangeComposable
import org.frms.paper.equal.gold.activities.composable.HelpCenterComposable
import org.frms.paper.equal.gold.activities.composable.ReservationPreview
import org.frms.paper.equal.gold.activities.composable.SellComposable
import org.frms.paper.equal.gold.activities.composable.VipComposable
import org.frms.paper.equal.gold.ui.theme.EPaperTheme
import org.frms.paper.equal.gold.ui.theme.Purple40
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *测试类
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/14 下午 05:28
 */
class TestActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		val loadInt = intent.getIntExtra("key", 0)

		WindowCompat.setDecorFitsSystemWindows(window, false)

		setContent {
			EPaperTheme(showSystemBar = false) {

				val systemUiController = rememberSystemUiController()
				val isDark = isSystemInDarkTheme()

				SideEffect {
					systemUiController.setStatusBarColor(
						Color.Transparent, darkIcons = !isDark
					)
				}

				when (loadInt)
				{
					0 ->
					{
						Column(
							modifier = Modifier
								.fillMaxSize()
								.background(backgroundGray)
						) {
							BuyTopBar(
								text = "界面展示",
							)

							TestButton("主界面") {
								startActivity()
							}
							Spacer(modifier = Modifier.height(10.dp))

							TestButton("帮助中心") {
								startHelpCenterActivity()
							}

							Spacer(modifier = Modifier.height(10.dp))

							TestButton("兑换中心") {
								startExchangeCenterActivity()
							}

							Spacer(modifier = Modifier.height(10.dp))

							TestButton("购物车") {
								startCartActivity()
							}

							Spacer(modifier = Modifier.height(10.dp))

							TestButton("捐赠") {
								startDonateActivity()
							}

							Spacer(modifier = Modifier.height(10.dp))

							TestButton("售卖") {
								startSellActivity()
							}

							Spacer(modifier = Modifier.height(10.dp))

							TestButton("上门服务") {
								startReservationServiceActivity()
							}

							Spacer(modifier = Modifier.height(10.dp))

							TestButton("Vip购买") {
								startVipActivity()
							}

							Spacer(modifier = Modifier.height(10.dp))

							TestButton("主界面-新闻") {
								startNewsActivity()
							}


							Spacer(modifier = Modifier.height(10.dp))

							TestButton("搜索界面-新闻") {
								startNewsSearchActivity()
							}

							Spacer(modifier = Modifier.height(10.dp))

							TestButton("结果界面-新闻") {
								startNewsSearchActivity()
							}
						}
					}

					1 ->
					{
						HelpCenterComposable()
					}

					2 ->
					{
						ExchangeComposable()
					}

					3 ->
					{
						CartPreview()
					}

					4 ->
					{
						DonateComposablePreview()
					}

					5 ->
					{
						SellComposable()
					}

					6 ->
					{
						ReservationPreview()
					}

					7 ->
					{
						VipComposable()
					}

					8 ->
					{						//NewComposableExtracted()
					}

					9 ->
					{ //						SearchPreview()
					}

					10 ->
					{

					}
				}
			}
		}
	}

	private fun startNewsActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 8)
		})
	}

	private fun startNewsSearchActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 9)
		})
	}

	private fun startNewsResultActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 10)
		})
	}

	private fun startVipActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 7)
		})
	}

	private fun startReservationServiceActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 6)
		})
	}

	private fun startSellActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 5)
		})
	}

	private fun startDonateActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 4)
		})
	}


	@Composable
	private fun TestButton(
		name: String,
		onClick: () -> Unit
	)
	{
		Button(
			modifier = Modifier
				.width(220.dp)
				.height(52.dp), onClick = { onClick() }, colors = ButtonDefaults.buttonColors(
				containerColor = Purple40
			)
		) {
			Text(
				text = name, style = h1
			)
		}
	}

	private fun startHelpCenterActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 1)
		})
	}

	private fun startActivity()
	{
		this.startActivity(Intent(this, MainActivity::class.java))
	}

	private fun startExchangeCenterActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 2)
		})
	}

	private fun startCartActivity()
	{
		startActivity(Intent(this, TestActivity::class.java).also {
			it.putExtra("key", 3)
		})
	}

}
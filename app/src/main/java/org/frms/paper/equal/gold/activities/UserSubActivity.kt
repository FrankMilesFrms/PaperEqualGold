/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(UserSubActivity.kt) is part of E纸千金.
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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.frms.paper.equal.gold.activities.composable.CartPreview
import org.frms.paper.equal.gold.activities.composable.DonateComposablePreview
import org.frms.paper.equal.gold.activities.composable.ExchangeComposable
import org.frms.paper.equal.gold.activities.composable.HelpCenterComposable
import org.frms.paper.equal.gold.activities.composable.SellComposable
import org.frms.paper.equal.gold.activities.composable.VipComposable
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_BG
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_BUY
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_DONATE
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_EXCHANGE
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_HELP_CENTER
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_HELP_SERVICE
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_LOAD
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_SELL
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_VIP
import org.frms.paper.equal.gold.ui.theme.EPaperTheme

/**
 * @author Frms(Frank Miles)
 * @email 3505826836@qq.com
 * @time 2023/04/11 上午 10:28
 */
class UserSubActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		val composeStr = intent.getStringExtra(USER_LOAD) ?: USER_VIP
		setContent {
			EPaperTheme(showSystemBar = true) {
				UserSurface(composeStr)
			}
		}
	}

	@Composable
	private fun UserSurface(composeStr: String)
	{
		when (composeStr)
		{
			USER_SELL        -> SellComposable { finish() }
			USER_DONATE      -> DonateComposablePreview { finish() }
			USER_BUY         -> CartPreview { finish() }
			USER_VIP         -> VipComposable { finish() }
			USER_EXCHANGE    -> ExchangeComposable { finish() }
			USER_HELP_CENTER -> HelpCenterComposable { finish() }

			else             ->
			{
				Box(modifier = Modifier.fillMaxSize()) {
					Text(text = "未添加")
				}
			}
		}

	}
}
 
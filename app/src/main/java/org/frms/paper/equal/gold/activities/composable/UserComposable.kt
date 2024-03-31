/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(UserComposable.kt) is part of E纸千金.
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

import android.graphics.drawable.shapes.Shape
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.SellerCard
import org.frms.paper.equal.gold.composes.ShapeImage
import org.frms.paper.equal.gold.composes.UserInformation
import org.frms.paper.equal.gold.composes.UserSettingList
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *个人界面中心
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/05 下午 02:26
 */
/**
 * 用户界面
 * @param innerPadding PaddingValues
 * @param name String
 * @param phoneNumber String
 * @param iconClick Function0<Unit>
 * @param shopClick Function0<Unit>
 * @param donateClick Function0<Unit>
 * @param cartClick Function0<Unit>
 * @param vipClick Function0<Unit>
 * @param exchangeClick Function0<Unit>
 * @param bgClick Function0<Unit>
 * @param clearCacheClick Function0<Unit>
 * @param helpCenterClick Function0<Unit>
 * @param helpServiceClick Function0<Unit>
 */
@Composable
fun UserComposable(
	innerPadding: PaddingValues,
	userClick: UserClick
)
{

	views(
		innerPadding, name = userClick.name, phoneNumber = userClick.phoneNumber, iconClick = userClick.iconClick, shopClick = userClick.shopClick, donateClick = userClick.donateClick, cartClick = userClick.cartClick, vipClick = userClick.vipClick, exchangeClick = userClick.exchangeClick, bgClick = userClick.bgClick, clearCacheClick = userClick.clearCacheClick, helpCenterClick = userClick.helpCenterClick, helpServiceClick = userClick.helpServiceClick
	)
}

@Composable
private fun views(
	innerPadding: PaddingValues,

	name: String,
	phoneNumber: String,
	iconClick: () -> Unit,

	shopClick: () -> Unit,
	donateClick: () -> Unit,
	cartClick: () -> Unit,

	vipClick: () -> Unit,
	exchangeClick: () -> Unit,
	bgClick: () -> Unit,

	clearCacheClick: () -> Unit,
	helpCenterClick: () -> Unit,
	helpServiceClick: () -> Unit
)
{
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
			.verticalScroll(rememberScrollState())
			.padding(innerPadding)
	) {		// 用户信息
		UserInformation(
			painter = painterResource(id = R.drawable.shop_1), name = name, phone = phoneNumber, iconClick = iconClick
		)

		Spacer(modifier = Modifier.height(15.dp))

		// 卖家卡片
		SellerCard(
			iconAction1 = IconActionPainter(
				painter = painterResource(id = R.drawable.user_shop), text = stringResource(id = R.string.sell), onClick = shopClick
			), iconAction2 = IconActionPainter(
				painter = painterResource(id = R.drawable.user_donate), text = stringResource(id = R.string.donate), onClick = donateClick
			), iconAction3 = IconActionPainter(
				painter = painterResource(id = R.drawable.act_buy), text = stringResource(id = R.string.act_buy), onClick = cartClick
			), title = stringResource(id = R.string.seller)
		)

		Spacer(modifier = Modifier.height(10.dp))

		// 更多服务
		SellerCard(
			iconAction1 = IconActionPainter(
				painter = painterResource(id = R.drawable.user_vip_icon), text = stringResource(id = R.string.user_vip), onClick = vipClick
			), iconAction2 = IconActionPainter(
				painter = painterResource(id = R.drawable.user_exchange), text = stringResource(id = R.string.user_exchange), onClick = exchangeClick
			), iconAction3 = IconActionPainter(
				painter = painterResource(id = R.drawable.user_bg_icon), text = stringResource(id = R.string.user_background), onClick = bgClick
			), title = stringResource(id = R.string.user_more_service)
		)

		Spacer(modifier = Modifier.height(15.dp))

		Column {
			Divider(
				modifier = Modifier
					.fillMaxWidth()
					.background(
						Color(
							219, 219, 219
						)
					)
					.padding(
						start = 15.dp, end = 15.dp
					), thickness = 0.5.dp
			)

			UserSettingList(
				name = "清理缓存", painter = painterResource(id = R.drawable.user_clear_cache)
			) {
				clearCacheClick()
			}

			UserSettingList(
				name = "帮助中心", painter = painterResource(id = R.drawable.user_help_center)
			) {
				helpCenterClick()
			}

			UserSettingList(
				name = "客服中心", painter = painterResource(id = R.drawable.user_help_service)
			) {
				helpServiceClick()
			}
		}

	}
}

data class UserClick(
	val name: String,
	val phoneNumber: String,
	val iconClick: () -> Unit,

	val shopClick: () -> Unit,
	val donateClick: () -> Unit,
	val cartClick: () -> Unit,

	val vipClick: () -> Unit,
	val exchangeClick: () -> Unit,
	val bgClick: () -> Unit,

	val clearCacheClick: () -> Unit,
	val helpCenterClick: () -> Unit,
	val helpServiceClick: () -> Unit
)

data class IconActionPainter(
	val painter: Painter,
	val text: String,
	val onClick: () -> Unit = {}
)
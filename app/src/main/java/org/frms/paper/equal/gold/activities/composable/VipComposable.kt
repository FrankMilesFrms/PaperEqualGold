/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(VipComposable.kt) is part of E纸千金.
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.NormalBackTopBar
import org.frms.paper.equal.gold.composes.PayColumn
import org.frms.paper.equal.gold.composes.SelectVipCard
import org.frms.paper.equal.gold.composes.VipPreview
import org.frms.paper.equal.gold.ui.theme.PurpleMain
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/24 下午 11:52
 */
@Composable
fun VipComposable(onClickBack: () -> Unit = {})
{
	Column(modifier = Modifier
		.fillMaxSize()
		.background(backgroundGray)) {
		NormalBackTopBar(title = "会员购买", onClickBack = onClickBack)

		Row(
			horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()
		) {
			SelectVipCard(selected = true, info = "包月", price = 29)
			SelectVipCard(info = "包季", price = 79)
			SelectVipCard(info = "包月", price = 199)
		}
		Spacer(modifier = Modifier.height(15.dp))
		PayColumn(
			"微信支付", "如果需要取消续订，请在微信中勾销。", painterResource(id = R.drawable.pay_wechat_pay)
		)

		Spacer(modifier = Modifier.height(15.dp))
		PayColumn(
			"WeChat Pay", "Please cancel renewal in WeChat.", painterResource(id = R.drawable.pay_wechat_pay)
		)
		Spacer(modifier = Modifier.height(85.dp))
		Row(
			Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
		) {
			Button(
				onClick = { /*TODO*/ }, modifier = Modifier.width(250.dp), colors = ButtonDefaults.buttonColors(containerColor = PurpleMain)
			) {
				Text(text = "确认")
			}
		}

		Spacer(modifier = Modifier.height(15.dp))

		Row(
			modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
		) {
			Checkbox(checked = false, onCheckedChange = {})

			Text(
				text = "订阅专属优惠通知。", style = h1
			)
		}
	}

}
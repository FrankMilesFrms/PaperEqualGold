/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(SellComposable.kt) is part of E纸千金.
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.composes.GoodsTypeChoice
import org.frms.paper.equal.gold.composes.SubTipsText
import org.frms.paper.equal.gold.composes.DonateTypeButtons
import org.frms.paper.equal.gold.composes.NormalBackTopBar
import org.frms.paper.equal.gold.datas.sell_info
import org.frms.paper.equal.gold.ui.theme.PurpleMain
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 * todo 销售界面
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/24 下午 11:13
 */
@Preview
@Composable
fun SellComposable(onClickBack: () -> Unit = {})
{
	var a by remember {
		mutableStateOf(true)
	}

	var b by remember {
		mutableStateOf(false)
	}

	val list = arrayListOf(
		"查看订单" to a, "详细说明" to b
	)

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
	) {
		NormalBackTopBar(title = "卖", onClickBack = onClickBack)

		GoodsTypeChoice("售卖类型")

		Spacer(modifier = Modifier.height(15.dp))

		GoodsPrice()

		Spacer(modifier = Modifier.height(15.dp))


		SubTipsText("捐赠说明", sell_info)

		Spacer(modifier = Modifier.height(15.dp))

		DonateTypeButtons(tags = list)

		Spacer(modifier = Modifier.height(15.dp))


		Row(
			Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
		) {
			Button(
				onClick = { /*TODO*/ }, modifier = Modifier.width(135.dp), colors = ButtonDefaults.buttonColors(containerColor = PurpleMain)
			) {
				Text(text = "确认结算")
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoodsPrice()
{
	Column(modifier = Modifier.fillMaxWidth()) {
		OutlinedTextField(
			value = "", onValueChange = {}, modifier = Modifier
				.fillMaxWidth()
				.padding(start = 15.dp, end = 15.dp), label = {
				Text(text = "价格设定(￥)")
			}, colors = TextFieldDefaults.outlinedTextFieldColors()
		)
	}
}

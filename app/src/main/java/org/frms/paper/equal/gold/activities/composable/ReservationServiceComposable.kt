/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(ReservationServiceComposable.kt) is part of E纸千金.
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.composes.NormalBackTopBar
import org.frms.paper.equal.gold.composes.SubTipsText
import org.frms.paper.equal.gold.ui.theme.PurpleMain
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/24 下午 11:42
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ReservationPreview()
{
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
	) {
		NormalBackTopBar(title = "上门服务")

		OutlinedTextField(
			value = "", onValueChange = {}, modifier = Modifier
				.fillMaxWidth()
				.padding(
					start = 15.dp, end = 15.dp
				), label = {
				Text(text = "你的名字")
			}, colors = TextFieldDefaults.outlinedTextFieldColors()
		)

		Spacer(modifier = Modifier.height(15.dp))

		OutlinedTextField(
			value = "", onValueChange = {}, modifier = Modifier
				.fillMaxWidth()
				.padding(
					start = 15.dp, end = 15.dp
				), label = {
				Text(text = "联系方式")
			}, colors = TextFieldDefaults.outlinedTextFieldColors()
		)

		Spacer(modifier = Modifier.height(15.dp))

		OutlinedTextField(
			value = "", onValueChange = {}, modifier = Modifier
				.fillMaxWidth()
				.padding(
					start = 15.dp, end = 15.dp
				), label = {
				Text(text = "上门地址")
			}, colors = TextFieldDefaults.outlinedTextFieldColors()
		)

		SubTipsText(
			title = "服务说明", message = "  服务说明 fontWeight".repeat(15)
		)

		Spacer(modifier = Modifier.height(15.dp))

		Row(
			Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
		) {
			Button(
				onClick = { /*TODO*/ }, modifier = Modifier.width(135.dp), colors = ButtonDefaults.buttonColors(containerColor = PurpleMain)
			) {
				Text(text = "确认")
			}
		}
	}
}
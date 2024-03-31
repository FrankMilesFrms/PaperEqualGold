/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(DonateCompose.kt) is part of E纸千金.
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
package org.frms.paper.equal.gold.composes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.ui.theme.PurpleMain
import org.frms.paper.equal.gold.ui.theme.PurplePressed
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/24 下午 09:56
 */

@Preview
@Composable
fun DonatePreview()
{

}

@Composable
fun SubTipsText(
	title: String,
	message: String
)
{
	Column(modifier = Modifier.fillMaxWidth()) {
		Text(
			text = title, style = h1, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp)
		)

		Text(
			text = message, style = h1, fontWeight = FontWeight.Light, modifier = Modifier.padding(start = 10.dp)
		)
	}
}

@Composable
fun DonateTypeButtons(
	title: String = "",
	tags: List<Pair<String, Boolean>>
)
{
	var selectInt by remember {
		mutableStateOf("")
	}

	Column(modifier = Modifier.fillMaxWidth()) {

		if (title.isNotEmpty())
		{
			Text(
				text = "捐赠类型", style = h1, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp)
			)

		}

		Row(
			horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
		) {
			tags.forEach {
				SelectButton(text = it.first, selectInt == it.first) {
					selectInt = it
				}
			}
		}
	}
}


@Composable
fun GoodsTypeChoice(
	title: String
)
{
	val tags = arrayListOf("上门取件", "定点取件", "延时办理")
	var selectedTag = remember { mutableStateOf("Null") }

	Column(modifier = Modifier.fillMaxWidth()) {
		Text(
			text = title, style = h1, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp)
		)


		Row(
			horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
		) {
			tags.forEach {
				Row(
					horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
				) {
					RadioButton(
						selected = it == selectedTag.value, onClick = {
							selectedTag.value = it
						}, colors = RadioButtonDefaults.colors(
							selectedColor = PurpleMain
						)
					)

					Text(text = it)
				}
			}
		}
	}
}


@Composable
fun SelectButton(
	text: String,
	pressed: Boolean = false,
	modifier: Modifier = Modifier,
	onClick: (String) -> Unit = {}
)
{

	Button(
		onClick = { onClick(text) }, modifier = modifier, colors = ButtonDefaults.buttonColors(
			containerColor = if (pressed) PurplePressed else PurpleMain
		)
	) {
		Text(
			text = text, style = h1
		)
	}
}
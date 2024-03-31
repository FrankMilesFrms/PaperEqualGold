/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(NewsCompose.kt) is part of E纸千金.
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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.frms.paper.equal.gold.ui.theme.bodyFont
import org.frms.paper.equal.gold.ui.theme.bodyFont1
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *主界面-新闻
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/04/09 上午 10:16
 */

/**
 * 新闻卡片
 * @param messageId Int
 * @param title String
 * @param subMessage String
 * @param onClick Function1<Int, Unit>
 */
@Composable
fun NewMessage(
	messageId: Int,
	title: String,
	subMessage: String,
	onClick: (Int) -> Unit = {}
)
{
	Surface(
		modifier = Modifier
			.fillMaxWidth()
			.height(IntrinsicSize.Min)
			.padding(
				top = 5.dp, bottom = 5.dp
			)
			.clickable {
				onClick(messageId)
			}, color = Color.White
	) {
		Column(
			Modifier
				.fillMaxSize()
				.padding(8.dp)
		) {
			Text(
				text = title, style = h1, fontSize = 24.sp, fontWeight = FontWeight.Bold
			)
			Text(text = subMessage, style = bodyFont, maxLines = 5)
		}
	}
}

/**
 * 详细消息
 * @param title String
 * @param message String
 */
@Composable
fun NewsMessageInfo(
	title: String,
	message: String
)
{
	Column(
		Modifier
			.fillMaxSize()
			.padding(8.dp)
			.verticalScroll(rememberScrollState())
	) {
		Text(
			text = title, style = h1, fontSize = 24.sp, fontWeight = FontWeight.Bold
		)

		Divider(modifier = Modifier.fillMaxWidth())
		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = message,
			fontSize = 20.sp,
			style = bodyFont1,
		)
	}
}


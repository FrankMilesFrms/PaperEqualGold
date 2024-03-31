/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(NewsComposable.kt) is part of E纸千金.
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.composes.NewMessage
import org.frms.paper.equal.gold.datas.newsMessage
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 *主界面-新闻消息界面
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/04/09 上午 10:14
 */


@Composable
fun NewMainComposable(
	innerPadding: PaddingValues?,
	onClick: (Int) -> Unit
)
{
	val modifier = Modifier
		.fillMaxSize()
		.background(backgroundGray)
	LazyColumn(modifier = modifier.statusBarsPadding(), contentPadding = innerPadding.run {
		this ?: PaddingValues(0.dp)
	}) {		// todo 主界面-新闻消息界面
		// 这个也用于检索界面
		items(newsMessage.size) {
			NewMessage(
				messageId = it, title = newsMessage[it].first, subMessage = newsMessage[it].second
			) {
				onClick(it)
			}
		}
	}
}
/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(HelpCenterComposable.kt) is part of E纸千金.
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
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.CardTopBar
import org.frms.paper.equal.gold.composes.HelpCenterCard
import org.frms.paper.equal.gold.composes.NormalBackTopBar
import org.frms.paper.equal.gold.datas.helpCenterSubtitle
import org.frms.paper.equal.gold.datas.helpCenterTitle
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 *帮助中心
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/14 下午 05:07
 */
@Preview
@Composable
fun HelpCenterComposable(onClickBack: () -> Unit = {})
{
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
	) {
		NormalBackTopBar(title = "帮助中心", onClickBack = onClickBack)

		LazyColumn(
			modifier = Modifier
				.fillMaxWidth()
				.padding(
					start = 8.dp, end = 8.dp
				)
		) {
			items(helpCenterTitle.size) {
				HelpCenterCard(HelpCenterCardData(helpCenterTitle[it], painterResource(id = R.drawable.act_user), subtitles = helpCenterSubtitle[it].run {
					arrayListOf(first, second, third)
				}))

				Spacer(modifier = Modifier.height(15.dp))
			}
		}
	}
}

/**
 * 帮助卡片
 * @property title String
 * @property titleIcon Painter
 * @property iconDescription String
 * @property subtitles List<String>
 * @constructor
 */
data class HelpCenterCardData(
	val title: String,
	val titleIcon: Painter,
	val iconDescription: String = title,
	val subtitles: List<String>
)
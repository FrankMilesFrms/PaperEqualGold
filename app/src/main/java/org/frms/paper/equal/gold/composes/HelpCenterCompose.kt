/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(HelpCenterCompose.kt) is part of E纸千金.
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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.activities.composable.HelpCenterCardData
import org.frms.paper.equal.gold.ui.theme.bodyFont
import org.frms.paper.equal.gold.ui.theme.h1

/**
 * 帮助中心卡片
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/14 下午 04:19
 */
@Composable
fun HelpCenterCard(
	helpCard: HelpCenterCardData,
	onClick: (String) -> Unit = {}
)
{
	OutlinedCard(
		modifier = Modifier
			.fillMaxWidth()
			.height(IntrinsicSize.Max)
			.clip(RoundedCornerShape(8.dp))
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp)
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.height(IntrinsicSize.Min)
					.padding(5.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start
			) {
				Icon(
					painter = helpCard.titleIcon, contentDescription = helpCard.iconDescription, modifier = Modifier.height(30.dp)
				)

				Spacer(modifier = Modifier.width(5.dp))

				Text(
					text = helpCard.title, modifier = Modifier.fillMaxWidth(), style = h1, textAlign = TextAlign.Start, fontWeight = FontWeight.Bold
				)
			}

			helpCard.subtitles.forEach {
				Text(
					text = it, modifier = Modifier
						.height(30.dp)
						.clickable {
							onClick(it)
						}, style = bodyFont
				)
			}
		}
	}
}
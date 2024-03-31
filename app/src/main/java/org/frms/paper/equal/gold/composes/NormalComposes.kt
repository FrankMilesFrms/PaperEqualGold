/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(NormalComposes.kt) is part of E纸千金.
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

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 * 存储通用组件
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/14 下午 05:43
 */

/**
 * 由左箭头 + 左侧名称组成的通知条
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalBackTopBar(
	title: String,
	onClickBack: () -> Unit = {}
)
{
	TopAppBar(title = {
		Text(
			text = title, style = h1
		)
	}, navigationIcon = {
		IconButton(onClick = { onClickBack() }) {
			Icon(
				imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(id = R.string.back)
			)
		}
	}, modifier = Modifier.statusBarsPadding(), colors = TopAppBarDefaults.smallTopAppBarColors(
		containerColor = backgroundGray
	)
	)
}

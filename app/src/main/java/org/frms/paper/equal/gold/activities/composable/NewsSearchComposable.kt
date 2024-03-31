/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(NewsSearchComposable.kt) is part of E纸千金.
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

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.composes.longClick
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.bodyFont
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *新闻搜索框
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/04/09 上午 10:42
 */
@SuppressLint("MutableCollectionMutableState")
@Composable
fun SearchPreview(
	list: SnapshotStateList<String>,
	clearData: () -> Unit,
	onLongClick: (String) -> Unit,
	onClick: (String) -> Unit,
)
{
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundGray)
	) {
		SearchBar(onClick)

		Spacer(modifier = Modifier.height(10.dp))

		FlowHistory(list, clearData = clearData, onClick = onClick, onLongClick = onLongClick)
	}
}

@Composable
fun SearchBar(
	searchClick: (String) -> Unit
)
{
	var text by remember {
		mutableStateOf("")
	}

	Row(
		modifier = Modifier
			.fillMaxWidth()
			.background(backgroundGray), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
	) {
		BasicTextField(value = text, onValueChange = {
			val t = if (it.contains('\n')) it.replace("\n", "")
			else it
			text = t
		}, decorationBox = { innerTextField ->
			Row(
				verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(
					vertical = 2.dp, horizontal = 8.dp
				)
			) {
				Row(
					modifier = Modifier/*.padding(top = 2.dp, start = 8.dp)*/.fillMaxHeight(),
					verticalAlignment = Alignment.CenterVertically,
				) {

					IconButton(
						onClick = { searchClick(text) }, modifier = Modifier.size(16.dp)
					) {
						Icon(
							imageVector = Icons.Filled.Search, contentDescription = stringResource(id = R.string.search)
						)
					}

					Box(
						modifier = Modifier.padding(horizontal = 10.dp), contentAlignment = Alignment.CenterStart
					) {
						if (text.isEmpty())
						{
							Text(
								text = "输入点东西看看吧~", style = TextStyle(
									color = Color(0, 0, 0, 128),
								), maxLines = 1
							)
						}
						innerTextField()
					}

				}
				if (text.isNotEmpty())
				{
					IconButton(
						onClick = { text = "" }, modifier = Modifier.size(16.dp)
					) {
						Icon(
							imageVector = Icons.Filled.Close, contentDescription = stringResource(id = R.string.close)
						)
					}
				}
			}
		},

		               modifier = Modifier
			               .padding(10.dp)
			               .background(
				               Color.White, CircleShape
			               )
			               .height(35.dp)
			               .fillMaxWidth(), maxLines = 1
		)

	}
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun FlowHistory(
	file: SnapshotStateList<String>,
	clearData: () -> Unit,
	onClick: (String) -> Unit,
	onLongClick: (String) -> Unit,
)
{
	if (file.size == 0 || (file.size == 1 && file[0].isBlank())) return

	Column {
		Text(text = "清除历史记录", modifier = Modifier.clickable {
			clearData()
		})
		Spacer(modifier = Modifier.height(10.dp))
		FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
			file.forEach {
				ChipExtracted(it = it, onClick = onClick, onLongClick = onLongClick)
			}
		}
	}
}

@Composable
fun NewsSearchClearDialog(
	showDialog: MutableState<Boolean>,
	onClick: () -> Unit
)
{
	AlertDialog(onDismissRequest = {
		showDialog.value = false
	}, title = {
		Text(text = "注意")
	}, text = {
		Text(
			"是否要删除所有数据？"
		)
	}, confirmButton = {
		TextButton(onClick = {
			onClick()
		}) {
			Text("确定")
		}
	}, dismissButton = {
		TextButton(onClick = {
			showDialog.value = false
		}) {
			Text("取消")
		}
	})
}

@Composable
private fun ChipExtracted(
	it: String,
	onClick: (String) -> Unit = {},
	onLongClick: (String) -> Unit = {},
)
{
	OutlinedCard(
		shape = RoundedCornerShape(10.dp),
		modifier = Modifier
			.height(IntrinsicSize.Min)
			.padding(bottom = 5.dp)
			.pointerInput(Unit) {
				detectTapGestures(onLongPress = { _ ->
					onLongClick(it)
				}, onTap = { _ ->
					onClick(it)
				})
			},
	) {
		Text(
			text = it, style = h1, fontSize = 18.sp, modifier = Modifier
				.fillMaxHeight()
				.padding(5.dp)

		)
	}
}


/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(NewsActivity.kt) is part of E纸千金.
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
package org.frms.paper.equal.gold.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.activities.composable.NewMainComposable
import org.frms.paper.equal.gold.activities.composable.NewsSearchClearDialog
import org.frms.paper.equal.gold.activities.composable.SearchPreview
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig.DS_GOODS_HISTORY
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig.DS_NEWS_HISTORY
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig.DS_SPLIT
import org.frms.paper.equal.gold.activities.configs.NewsConfig
import org.frms.paper.equal.gold.activities.configs.NewsConfig.NEWS_INFO
import org.frms.paper.equal.gold.activities.configs.NewsConfig.NEWS_RESULT
import org.frms.paper.equal.gold.activities.configs.NewsConfig.NEWS_SEARCH
import org.frms.paper.equal.gold.activities.configs.NewsConfig.TYPE_ID
import org.frms.paper.equal.gold.activities.configs.NewsConfig.TYPE_ID_NEWS
import org.frms.paper.equal.gold.activities.configs.NewsConfig.TYPE_ID_NEWS_SEARCH
import org.frms.paper.equal.gold.composes.NewsMessageInfo
import org.frms.paper.equal.gold.datas.Utils.showToast
import org.frms.paper.equal.gold.datas.newsInfo
import org.frms.paper.equal.gold.datas.newsMessage
import org.frms.paper.equal.gold.ui.theme.EPaperTheme
import org.frms.paper.equal.gold.ui.theme.backgroundGray

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/04/10 上午 11:59
 */
class NewsActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		val loadInt = intent.getIntExtra(TYPE_ID, TYPE_ID_NEWS)
		val messageId = intent.getIntExtra(NewsConfig.MESSAGE_ID, 0);

		val sharedPreferences = getSharedPreferences(DataStoreConfig.DS_NORMAL, MODE_PRIVATE)

		setContent {
			EPaperTheme(showSystemBar = true) {
				Surface(
					modifier = Modifier.fillMaxSize(), color = backgroundGray
				) {
					NewsNavHost(loadInt, messageId, sharedPreferences, this)
				}
			}
		}
	}

}

@Composable
fun NewsNavHost(
	loadInt: Int,
	messageId: Int,
	sp: SharedPreferences,
	ctx: NewsActivity
)
{
	val navController = rememberNavController()

	NavHost(
		navController = navController, startDestination = when (loadInt)
		{
			TYPE_ID_NEWS -> NEWS_INFO
			else         -> NEWS_SEARCH
		}
	) {
		composable(NEWS_SEARCH) {

			val key = if (loadInt == TYPE_ID_NEWS_SEARCH) DS_NEWS_HISTORY else DS_GOODS_HISTORY

			val list = remember {
				sp.getString(key, "")!!.split(DS_SPLIT).toMutableStateList()
			}


			SearchPreview(list, onLongClick = {
				list.remove(it)
				ctx.showToast("已删除")
				val sb = StringBuffer()
				list.forEach { sb.append(DS_SPLIT).append(it) }

				sp.edit().run {
					if (list.size > 0) putString(key, sb.substring(DS_SPLIT.length))
					else putString(key, "")
					apply()
				}
			},

			              onClick = {
				              if (it.isNotEmpty())
				              {

					              searchNews {

						              saveHistoryList(sp, list, key, it)

						              navController.navigate(NEWS_RESULT) {							// 点击Item时，清空栈内到popUpTo之间所有Item来避免栈增加并且使用saveState用于界面恢复
							              popUpTo(navController.graph.findStartDestination().id) {
								              saveState = true
							              }							// 避免多次点击产生重复实例
							              launchSingleTop =
								              true							// 中再次点击之前组件恢复状态
							              restoreState = true
						              }
					              }
				              }

			              }, clearData = {
					list.clear()
					ctx.showToast("已清空")

					sp.edit().run {
						putString(key, "")
						apply()
					}
				})
		}


		composable(NEWS_RESULT) {
			NewMainComposable(null) {
				navController.navigate(NEWS_INFO) {					// 点击Item时，清空栈内到popUpTo之间所有Item来避免栈增加并且使用saveState用于界面恢复
					popUpTo(navController.graph.findStartDestination().id) {
						saveState = true
					}					// 避免多次点击产生重复实例
					launchSingleTop = true					// 中再次点击之前组件恢复状态
					restoreState = true
				}
			}
		}


		composable(NEWS_INFO) {			// TODO: 点击新闻之后
			NewsMessageInfo(
				title = newsMessage[messageId].first, message = newsInfo[messageId]
			)
		}
	}
}

/**
 * 保存历史搜索记录
 * @param sp SharedPreferences
 * @param list SnapshotStateList<String>
 * @param key String
 * @param it String
 */
private fun saveHistoryList(
	sp: SharedPreferences,
	list: SnapshotStateList<String>,
	key: String,
	it: String,
)
{
	sp.edit().run {
		if (list.size == 1 && list[0].isBlank())
		{
			putString(
				key, it
			)
		} else if (list.contains(it).not())
		{
			putString(
				key, sp.getString(
					key, ""
				) + DS_SPLIT + it
			)
		}
		apply()
	}
}

// todo 发送服务数据，接受结果
fun searchNews(function: () -> Unit)
{
	function()
}

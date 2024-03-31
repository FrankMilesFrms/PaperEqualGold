/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(CenterActivity.kt) is part of E纸千金.
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

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.activities.composable.ActComposable
import org.frms.paper.equal.gold.activities.composable.BuyComposable
import org.frms.paper.equal.gold.activities.composable.BuyTopBar
import org.frms.paper.equal.gold.activities.composable.NewMainComposable
import org.frms.paper.equal.gold.activities.composable.OrderComposable
import org.frms.paper.equal.gold.activities.composable.UserClick
import org.frms.paper.equal.gold.activities.composable.UserComposable
import org.frms.paper.equal.gold.activities.configs.CenterActConfig
import org.frms.paper.equal.gold.activities.configs.CenterActConfig.CENTER_ACT_ACTIVITY
import org.frms.paper.equal.gold.activities.configs.CenterActConfig.CENTER_ACT_BUY
import org.frms.paper.equal.gold.activities.configs.CenterActConfig.CENTER_ACT_MESSAGE
import org.frms.paper.equal.gold.activities.configs.CenterActConfig.CENTER_ACT_ORDERS
import org.frms.paper.equal.gold.activities.configs.CenterActConfig.CENTER_ACT_USER
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig.DS_NORMAL
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig.DS_PHONE
import org.frms.paper.equal.gold.activities.configs.NewsConfig.MESSAGE_ID
import org.frms.paper.equal.gold.activities.configs.NewsConfig.TYPE_ID
import org.frms.paper.equal.gold.activities.configs.NewsConfig.TYPE_ID_BUY_SEARCH
import org.frms.paper.equal.gold.activities.configs.NewsConfig.TYPE_ID_NEWS
import org.frms.paper.equal.gold.activities.configs.NewsConfig.TYPE_ID_NEWS_SEARCH
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_BG
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_BUY
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_DONATE
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_EXCHANGE
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_HELP_CENTER
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_HELP_SERVICE
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_LOAD
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_NAME
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_SELL
import org.frms.paper.equal.gold.activities.configs.UserConfigs.USER_VIP
import org.frms.paper.equal.gold.composes.CardTopBar
import org.frms.paper.equal.gold.datas.IconData
import org.frms.paper.equal.gold.datas.Utils.showToast
import org.frms.paper.equal.gold.ui.theme.EPaperTheme
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *主界面
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/03 上午 10:40
 */
class CenterActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		WindowCompat.setDecorFitsSystemWindows(
			window, false
		)

		setContent {
			EPaperTheme(showSystemBar = false) {
				Surface(
					modifier = Modifier.fillMaxSize(), color = backgroundGray
				) {
					App(this)
				}
			}
		}
	}
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(activity: CenterActivity)
{
	val navController = rememberNavController()

	val items = listOf(
		IconData(
			CENTER_ACT_MESSAGE, R.drawable.act_message, R.string.message
		),
		IconData(
			CENTER_ACT_BUY, R.drawable.act_buy, R.string.act_buy
		),
		IconData(
			CENTER_ACT_ACTIVITY, R.drawable.act_act, R.string.act_act
		),
		IconData(
			CENTER_ACT_ORDERS, R.drawable.act_orders, R.string.act_orders
		),
		IconData(
			CENTER_ACT_USER, R.drawable.act_user, R.string.act_user
		),
	)

	val sp = activity.getSharedPreferences(DS_NORMAL, MODE_PRIVATE)

	val userClick = UserClick(

		name = sp.getString(USER_NAME, "默认昵称")!!, phoneNumber = sp.getString(DS_PHONE, "")!!, iconClick = {
			activity.showToast("不支持")
		},

		shopClick = {
			gotoSubUserActivity(activity, USER_SELL)
		}, donateClick = {
			gotoSubUserActivity(activity, USER_DONATE)
		}, cartClick = {
			gotoSubUserActivity(activity, USER_BUY)
		},

		vipClick = {
			gotoSubUserActivity(activity, USER_VIP)
		}, exchangeClick = {
			gotoSubUserActivity(activity, USER_EXCHANGE)
		}, bgClick = {
			gotoSubUserActivity(activity, USER_BG)
		},

		clearCacheClick = {			// todo
			activity.showToast("已清除")
		},

		helpCenterClick = {
			gotoSubUserActivity(activity, USER_HELP_CENTER)
		}, helpServiceClick = {
			gotoSubUserActivity(activity, USER_HELP_SERVICE)
		})

	Scaffold(
		topBar = {
			CenterActTopBar(navController, activity = activity)
		},

		bottomBar = {
			Column(modifier = Modifier.fillMaxWidth()) {
				BottomBar(navController, items)
				Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
			}
		},
	) { innerPadding ->
		CenterHost(navController, innerPadding, activity, userClick)
	}


}

/**
 * Host 跳转
 * @param navController NavHostController
 * @param innerPadding PaddingValues
 * @param activity CenterActivity
 */
@Composable
private fun CenterHost(
	navController: NavHostController,
	innerPadding: PaddingValues,
	activity: CenterActivity,
	userClick: UserClick
)
{
	NavHost(
		navController = navController, startDestination = CENTER_ACT_MESSAGE
	) {
		composable(CENTER_ACT_MESSAGE) {
			NewMainComposable(innerPadding = innerPadding) {
				gotoNewsActivity(activity, TYPE_ID_NEWS, it)
			}
		}

		composable(CENTER_ACT_BUY) {
			BuyComposable(innerPadding, activity)
		}

		composable(CENTER_ACT_ACTIVITY) {			// 活动详情
			ActComposable(innerPadding) {
				gotoNewsActivity(activity, TYPE_ID_NEWS)
			}
		}
		composable(CENTER_ACT_ORDERS) {
			OrderComposable(innerPadding)
		}
		composable(CENTER_ACT_USER) {

			UserComposable(
				innerPadding, userClick
			)
		}

	}
}

fun gotoNewsActivity(
	activity: CenterActivity,
	id: Int,
	msgInt: Int = 0
)
{
	activity.startActivity(Intent(activity, NewsActivity::class.java).apply {
		putExtra(TYPE_ID, id)
		putExtra(MESSAGE_ID, msgInt)
	})
}

fun gotoSubUserActivity(
	activity: CenterActivity,
	id: String
)
{
	activity.startActivity(Intent(activity, UserSubActivity::class.java).apply {
		putExtra(USER_LOAD, id)
	})
}

/**
 * 主界面标题
 * @param navController NavHostController
 * @param items List<IconData>
 */
@Composable
private fun CenterActTopBar(
	navController: NavHostController,
	activity: CenterActivity
)
{
	navController.currentBackStackEntryAsState().value?.destination?.route.let {
		when (it)
		{
			CENTER_ACT_MESSAGE ->
			{
				BuyTopBar(text = stringResource(id = R.string.message)) {					// search news
					gotoNewsActivity(activity = activity, TYPE_ID_NEWS_SEARCH)
				}
			}

			CENTER_ACT_BUY ->
			{
				BuyTopBar(text = stringResource(id = R.string.app_name)) {
					gotoNewsActivity(activity = activity, TYPE_ID_BUY_SEARCH)
				}
			}

			CENTER_ACT_ACTIVITY ->
			{
				CardTopBar(text = stringResource(id = R.string.act_act))
			}

			CENTER_ACT_ORDERS ->
			{
				CardTopBar(text = stringResource(id = R.string.act_orders))
			}

			CENTER_ACT_USER ->
			{
				BuyTopBar(text = stringResource(id = R.string.act_user), imageVector = Icons.Filled.MailOutline)
			}
		}

	}
}


/**
 * 底部导航条
 * @param navController NavController
 * @param items List<IconData>
 */
@Composable
private fun BottomBar(
	navController: NavController,
	items: List<IconData>,
)
{
	val navBackStackEntry = navController.currentBackStackEntryAsState()
	val currentDestination = navBackStackEntry.value?.destination

	NavigationBar(
		containerColor = Color(35, 35, 35)
	) {
		items.forEach {
			NavigationBarItem(icon = {
				Icon(
					painterResource(it.res), contentDescription = stringResource(id = it.description), modifier = Modifier.size(25.dp)
				)
			}, label = {
				Text(
					text = stringResource(id = it.description), style = h1, color = Color.White
				)
			}, selected = currentDestination?.hierarchy?.any { that -> it.route == that.route } == true, onClick = {
				jumpCompose(
					currentDestination, it, navController
				)

			}, colors = NavigationBarItemDefaults.colors(
				unselectedIconColor = Color.White
			)
			)
		}
	}
}

// 跳转
private fun jumpCompose(
	currentDestination: NavDestination?,
	it: IconData,
	navController: NavController,
)
{
	if (currentDestination?.hierarchy?.any { that -> it.route == that.route } == false)
	{
		navController.navigate(it.route) {			// 点击Item时，清空栈内到popUpTo之间所有Item来避免栈增加并且使用saveState用于界面恢复
			popUpTo(navController.graph.findStartDestination().id) {
				saveState = true
			}			// 避免多次点击产生重复实例
			launchSingleTop = true			// 中再次点击之前组件恢复状态
			restoreState = true
		}
	}
}
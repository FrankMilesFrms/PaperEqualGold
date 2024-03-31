/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(MainActivity.kt) is part of E纸千金.
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

package org.frms.paper.equal.gold

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.core.view.WindowCompat
import org.frms.paper.equal.gold.activities.CenterActivity
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig.DS_INIT
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig.DS_NORMAL
import org.frms.paper.equal.gold.activities.configs.DataStoreConfig.DS_PHONE
import org.frms.paper.equal.gold.composes.LoginCompose
import org.frms.paper.equal.gold.composes.StartCompose
import org.frms.paper.equal.gold.datas.Utils.openURL
import org.frms.paper.equal.gold.datas.Utils.showToast
import org.frms.paper.equal.gold.ui.theme.EPaperTheme
import org.frms.paper.equal.gold.ui.theme.backgroundGray


/**
 * 登录界面。
 * 有些界面并不是必须的，因此需要判定是否为首次使用。
 */
class MainActivity : ComponentActivity()
{

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		WindowCompat.setDecorFitsSystemWindows(window, false)

		val ds = getSharedPreferences(DS_NORMAL, MODE_PRIVATE)

		if (ds.getBoolean(DS_INIT, false))
		{
			gotoCenterActivity()
		}

		setContent {

			val phone = remember { mutableStateOf("") }

			val verify = remember { mutableStateOf("") }

			EPaperTheme(showSystemBar = false) {
				Surface(
					modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
				) {
					Box(modifier = Modifier
						.fillMaxSize()
						.background(backgroundGray)) {
						Image(
							painter = painterResource(id = R.drawable.act_bg), contentDescription = "背景", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
						)

						StartCompose {
							LoginCompose(phoneNumber = phone, verificationCode = verify, openURL = {
								openURL(it)
							}) { //								if(phone.value.length != 11) {
								//									showToast("号码格式不正确")
								//								} else if(verify.value.length != 6){
								//									showToast("验证码格式不正确，为6位")
								//								} else {
								//
								//								}
								verification(phone, verify) {

									ds.edit().run {
										putString(DS_PHONE, phone.value)
										putBoolean(DS_INIT, true)
										apply()
									}

									gotoCenterActivity()
								}
							}
						}
					}

				}
			}
		}
	}

	/**
	 * 上传数据验证是否成功登录
	 * @param phone MutableState<String>
	 * @param verify MutableState<String>
	 * @param function Function0<Unit>
	 */
	private fun verification(
		phone: MutableState<String>,
		verify: MutableState<String>,
		function: () -> Unit,
	)
	{
		function()
	}

	private fun gotoCenterActivity()
	{
		startActivity(Intent(this, CenterActivity::class.java))
		finish()
	}
}
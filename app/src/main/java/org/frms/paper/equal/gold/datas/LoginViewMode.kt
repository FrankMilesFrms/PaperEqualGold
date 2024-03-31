/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(LoginViewMode.kt) is part of E纸千金.
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

package org.frms.paper.equal.gold.datas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

/**
 *管理登录状态代码：存储手机号、验证码，
 * 验证码
 *@property phoneNumber String 手机号码
 *@property prefixNumber String 区号
 *@property verifyCode String 验证码
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/02 下午 10:06
 */
data class LoginState(
	val phoneNumber: String,
	val prefixNumber: String,
	val verifyCode: String,
)


class LoginViewMode(
	private val loginState: LoginState
) : ViewModel()
{

}
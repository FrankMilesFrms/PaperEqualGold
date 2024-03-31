/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(LoginActCompose.kt) is part of E纸千金.
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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.datas.Utils
import org.frms.paper.equal.gold.ui.theme.Purple40
import org.frms.paper.equal.gold.ui.theme.PurpleMain
import org.frms.paper.equal.gold.ui.theme.blue
import org.frms.paper.equal.gold.ui.theme.h1
import org.frms.paper.equal.gold.ui.theme.smallFont

/**
 * 开始初始化-界面
 * @param content VIEWS
 */
@Composable
fun StartCompose(content: @Composable() AnimatedVisibilityScope.() -> Unit)
{
	var visible by remember {
		mutableStateOf(true)
	}
	AnimatedVisibility(
		visible = visible, enter = fadeIn(), exit = fadeOut()
	) {
		Box(Modifier.fillMaxSize()) {
			Box(
				modifier = Modifier.fillMaxSize() //					.background(Color.Gray)
			)
			Column(
				modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly
			) {
				Text(
					text = stringResource(id = R.string.main_name), modifier = Modifier.fillMaxWidth(), fontSize = 64.sp, textAlign = TextAlign.Center, style = h1
				)

				Button(
					modifier = Modifier
						.fillMaxWidth()
						.padding(32.dp), onClick = {
						visible = false
					}, colors = ButtonDefaults.buttonColors(
						containerColor = Purple40
					)
				) {
					Text(
						text = stringResource(id = R.string.start)
					)
				}
			}
		}
	}

	AnimatedVisibility(
		visible = !visible, enter = fadeIn(), exit = fadeOut()
	) {
		content()
	}
}

/**
 * 登录界面-用于注册用户，得到界面
 * @param phoneNumber 用户号码
 * @param verificationCode 验证码
 * @param onCountryChange 手机区号前缀
 * @param onVerifyButtonClick 发送验证码
 * @param openURL 打开URL 隐私条款/服务条款
 * @param onLoginClick 进入主界面
 */
@Composable
fun LoginCompose(
	phoneNumber: MutableState<String> = remember { mutableStateOf("") },
	verificationCode: MutableState<String> = remember { mutableStateOf("") },
	onCountryChange: (before: String) -> String = { it },
	onVerifyButtonClick: () -> Unit = {},
	openURL: (String) -> Unit = {},
	onLoginClick: () -> Unit
)
{
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(22.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
	) {

		Spacer(modifier = Modifier.height(120.dp))
		Text(
			text = stringResource(id = R.string.login), fontSize = 48.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
		)
		Spacer(modifier = Modifier.height(40.dp))

		TextFiledLogIn(
			height = 52.dp, value = phoneNumber.value, onValueChange = {
				if (phoneNumber.value.length < 12)
				{
					phoneNumber.value = it
				}
			}, onCountryChange = onCountryChange
		)

		Spacer(modifier = Modifier.height(30.dp))

		Row(modifier = Modifier.fillMaxWidth()) {
			VerificationCodeTextField(
				height = 52.dp, value = verificationCode.value, onValueChange = {
					verificationCode.value = it
				}, modifier = Modifier.weight(200f)
			)

			Spacer(modifier = Modifier.weight(35f))

			VerifyButton(
				modifier = Modifier
					.weight(150f)
					.height(52.dp), text = stringResource(id = R.string.get_verify_code), onClick = onVerifyButtonClick
			)
		}

		Spacer(modifier = Modifier.height(25.dp))

		TipText(modifier = Modifier.fillMaxWidth(), openURL = openURL)

		Spacer(modifier = Modifier.height(20.dp))

		Row(
			modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
		) {
			Button(
				modifier = Modifier
					.width(220.dp)
					.height(52.dp), onClick = onLoginClick, colors = ButtonDefaults.buttonColors(
					containerColor = Purple40
				)
			) {
				Text(
					text = stringResource(id = R.string.verify_login), style = h1
				)
			}
		}

	}


}

@Composable
fun TipText(
	modifier: Modifier,
	openURL: (String) -> Unit
)
{
	val prefix = stringResource(id = R.string.tip_login_prefix)
	val privacyAgreement = stringResource(id = R.string.privacy_agreement)
	val termsOfService = stringResource(id = R.string.terms_sevice)

	val annotationText = buildAnnotatedString {
		withStyle(
			style = SpanStyle(
				fontSize = 13.sp, color = Color(25, 28, 24)
			)
		) {
			append(prefix)
		}

		pushStringAnnotation(tag = "URL", annotation = stringResource(id = R.string.privacy_policy_url))

		withStyle(
			style = SpanStyle(
				fontSize = 13.sp, color = blue, fontStyle = FontStyle(R.font.alibabapuhuti)
			)
		) {

			append(privacyAgreement)
		}
		pop()

		withStyle(
			style = SpanStyle(
				fontSize = 13.sp, color = Color(25, 28, 24), fontStyle = FontStyle(R.font.alibabapuhuti)
			)
		) {
			append('&')
		}

		pushStringAnnotation(tag = "URL", annotation = stringResource(id = R.string.terms_service_url))
		withStyle(
			style = SpanStyle(
				fontSize = 13.sp, color = blue, fontStyle = FontStyle(R.font.alibabapuhuti)
			)
		) {
			append(termsOfService)
		}
		pop()
	}

	Row(
		modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
	) {
		ClickableText(text = annotationText, style = smallFont, onClick = {
			annotationText.getStringAnnotations(tag = "URL", start = it, end = it).firstOrNull()
				?.let { annotation ->
					openURL(annotation.item)
				}
		})
	}
}

/**
 * 初始手机号输入界面
 * @param height Dp
 * @param textSize Int
 * @param value String
 * @param onValueChange Function1<String, Unit>
 * @param onCountryChange Function1<[@kotlin.ParameterName] String, String>
 */
@Composable
fun TextFiledLogIn(
	height: Dp,
	value: String,
	modifier: Modifier = Modifier.fillMaxWidth(),
	onValueChange: (String) -> Unit,
	onCountryChange: (before: String) -> String
)
{
	var countryPrefix by remember {
		mutableStateOf("")
	}

	countryPrefix = stringResource(id = R.string.phone_prefix)

	Box(
		modifier = modifier,
		Alignment.CenterStart,
	) {
		BasicTextField(
			value = value, onValueChange = {
				if (it.isDigitsOnly())
				{
					onValueChange(it)
				}
			}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone), maxLines = 1,

			textStyle = androidx.compose.ui.text.TextStyle(
				color = Color.White, fontSize = h1.fontSize
			), decorationBox = { innerTextField ->

				Row(
					modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
				) {
					Spacer(modifier = Modifier.size(15.dp))

					Text(
						text = countryPrefix, modifier = Modifier.clickable {											// 改变手机区号
								countryPrefix = onCountryChange(countryPrefix)
							}, style = androidx.compose.ui.text.TextStyle(
							color = Color(255, 255, 255, 200), fontSize = h1.fontSize
						), maxLines = 1
					)

					Spacer(modifier = Modifier.size(4.dp))

					Box(contentAlignment = Alignment.CenterStart) {
						if (value.isEmpty())
						{
							Text(
								text = stringResource(id = R.string.empty_login_text_field), color = Color(255, 255, 255, 200), style = h1
							)
						}
						innerTextField()
					}
				}
			}, modifier = Modifier
				.background(
					color = PurpleMain, shape = CircleShape
				)
				.height(height)
				.fillMaxSize()
		)
	}
}


/**
 * 验证码输入框
 * @param height Dp
 * @param value String
 * @param onValueChange Function1<String, Unit>
 * @param modifier Modifier
 */
@Composable
fun VerificationCodeTextField(
	height: Dp,
	value: String,
	onValueChange: (String) -> Unit,
	modifier: Modifier = Modifier.fillMaxWidth()
)
{
	Box(
		modifier = modifier,
		Alignment.CenterStart,
	) {
		BasicTextField(
			value = value, onValueChange = {
				if (it.isDigitsOnly())
				{
					onValueChange(it)
				}
			}, maxLines = 1, textStyle = androidx.compose.ui.text.TextStyle(
				Color.White, fontSize = h1.fontSize
			), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone), decorationBox = { innerTextField ->

				Row(
					modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
				) {
					Spacer(modifier = Modifier.size(10.dp))

					Box(contentAlignment = Alignment.CenterStart) {
						if (value.isEmpty())
						{
							Text(
								text = stringResource(id = R.string.empty_verification_text_field), color = Color(255, 255, 255, 200), style = h1
							)
						}
						innerTextField()
					}
				}
			}, modifier = Modifier
				.background(
					color = PurpleMain, shape = CircleShape
				)
				.height(height)
				.fillMaxSize()
		)
	}
}


@Composable
fun VerifyButton(
	modifier: Modifier,
	isEnable: Boolean = true,
	text: String,
	onClick: () -> Unit,
)
{
	Button(
		onClick = onClick, enabled = isEnable, modifier = modifier.animateContentSize(), colors = ButtonDefaults.buttonColors(
			containerColor = Purple40
		)
	) {
		Text(
			text = text, style = h1, maxLines = 1
		)
	}
}
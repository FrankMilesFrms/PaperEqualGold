/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(ShopInfoActCompose.kt) is part of E纸千金.
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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import org.frms.paper.equal.gold.R
import org.frms.paper.equal.gold.datas.IconData
import org.frms.paper.equal.gold.ui.theme.NormalFont
import org.frms.paper.equal.gold.ui.theme.backgroundGray
import org.frms.paper.equal.gold.ui.theme.h1

/**
 *商店详情页
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/04 下午 07:10
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TestShopInfo()
{

}

@Composable
fun ShopBottomBar()
{
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(55.dp), verticalAlignment = Alignment.CenterVertically
	) {
		Box(
			modifier = Modifier
				.fillMaxHeight()
				.weight(1f)
				.background(
					Color(
						254, 194, 0
					)
				)
				.align(CenterVertically)
				.clickable {

				}, contentAlignment = Center
		) {
			Text(
				text = stringResource(id = R.string.add_to_cart), style = h1, modifier = Modifier, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, color = Color.White
			)
		}

		Box(
			modifier = Modifier
				.fillMaxHeight()
				.weight(1f)
				.background(
					Color(
						254, 79, 0
					)
				)
				.align(CenterVertically)
				.clickable {

				}, contentAlignment = Center
		) {
			Text(
				text = stringResource(id = R.string.act_buy), style = h1, modifier = Modifier, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, color = Color.White
			)
		}
	}
}


/**
 * @param shopRawPrice Int
 * @param shopNowPrice Int
 * @param discountMessage String
 */
@Composable
fun ShopPriceInfo(
	modifier: Modifier,
	shopRawPrice: Int,
	shopNowPrice: Int,
	discountMessage: String = "",
	shopName: String,
	shopMessage: String
)
{
	Column(modifier = modifier.fillMaxWidth()) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.height(40.dp)
				.padding(
					start = 15.dp, end = 15.dp
				),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
		) {
			Row(
				modifier = Modifier.height(40.dp),
				verticalAlignment = Alignment.CenterVertically,
			) {
				Text(
					text = "￥$shopNowPrice", style = h1, fontWeight = FontWeight.Bold, fontSize = 20.sp, maxLines = 1, color = Color(
						255, 80, 0
					)
				)
				Spacer(modifier = Modifier.width(15.dp))
				Text(
					text = "￥$shopRawPrice", style = h1, fontWeight = FontWeight.Bold, fontSize = 16.sp, maxLines = 1, color = Color.Gray, textAlign = TextAlign.End, textDecoration = TextDecoration.LineThrough
				)
				if (discountMessage.isEmpty())
				{
					Spacer(modifier = Modifier.width(20.dp))
					Text(
						text = discountMessage,
						style = h1,
						fontSize = 20.sp,
						maxLines = 1,
					)
				}
			}

			Text(
				text = "-${-(((shopNowPrice.toFloat() / shopRawPrice) * 100).toInt()) + 100}% ",
				modifier = Modifier.background(Color(0, 147, 51)),
				fontSize = 14.sp,
				fontStyle = TextStyle(
					fontSize = 18.sp, fontFamily = NormalFont
				).fontStyle,
				color = Color.White,
			)
		}
		Spacer(modifier = Modifier.height(5.dp))

		Text(
			text = shopName, modifier = Modifier
				.fillMaxWidth()
				.padding(start = 15.dp), style = h1, fontSize = 25.sp
		)
		Spacer(modifier = Modifier.height(5.dp))
		Spacer(
			modifier = Modifier
				.fillMaxWidth()
				.height(6.dp)
				.background(
					Color(
						194, 187, 187, 228
					)
				)
		)

		Text(
			text = stringResource(id = R.string.product_profile), fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier.padding(start = 5.dp)
		)
		Spacer(
			modifier = Modifier
				.fillMaxWidth()
				.height(10.dp)
		)
		Text(
			text = shopMessage, modifier = Modifier
				.fillMaxWidth()
				.padding(
					start = 5.dp, end = 5.dp
				), style = h1, fontWeight = FontWeight.Light
		)
	}
}

/**
 * 轮播图
 * @param auto Boolean
 * @param autoTime Long
 * @param listImage List<IconData>
 * @param onClick Function1<Int, Unit>
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerOne(
	auto: Boolean = false,
	autoTime: Long = 3000L,
	listImage: List<IconData>,
	onClick: (Int) -> Unit = {}
)
{

	val startIndex = Int.MAX_VALUE / 2
	val pagerState = rememberPagerState(initialPage = startIndex)
	val pageCountIndex = remember {
		derivedStateOf {
			(pagerState.currentPage - startIndex).floorMod(listImage.size)
		}
	}

	//使用时间来驱动轮播的时间间隔问题
	var currentTime by remember {
		mutableStateOf(10L)
	}

	if (auto)
	{
		LaunchedEffect(key1 = currentTime) {
			delay(autoTime)
			if (pagerState.currentPage == Int.MAX_VALUE - 1)
			{
				pagerState.animateScrollToPage(0)
			} else
			{
				pagerState.animateScrollToPage(pagerState.currentPage + 1)
			}
			currentTime = System.currentTimeMillis()
		}
	}

	Box(
		modifier = Modifier
			.fillMaxWidth()
			.aspectRatio(16 / 9f)
	) {
		HorizontalPager(
			count = Int.MAX_VALUE, state = pagerState, contentPadding = PaddingValues(horizontal = 0.dp), itemSpacing = 0.dp, modifier = Modifier.fillMaxSize()
		) {
			Box(
				modifier = Modifier //							.padding(horizontal = 10.dp)
					.background(Color.Blue)
					.fillMaxSize(), contentAlignment = Alignment.Center
			) {
				val now = (pagerState.currentPage - startIndex) % listImage.size

				Image(painter = painterResource(id = listImage[now].res), contentDescription = listImage[now].route, contentScale = ContentScale.FillBounds, modifier = Modifier
					.fillMaxSize()
					.clickable { onClick(now) })
			}
		}
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(bottom = 10.dp)
				.align(Alignment.BottomCenter), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
		) {
			repeat(listImage.size) { index ->
				Box(
					modifier = Modifier
						.padding(
							start = 2.dp, end = 2.dp
						)
						.width(if (index == pageCountIndex.value) 12.dp else 4.dp)
						.height(4.dp)
						.clip(if (index == pageCountIndex.value) RoundedCornerShape(2.dp) else CircleShape)
						.background(
							color = if (index == pageCountIndex.value) Color.Red else Color.DarkGray, shape = if (index == pageCountIndex.value) RoundedCornerShape(2.dp) else CircleShape
						)
				)
			}
		}
	}
}

//官方demo的一个算法
private fun Int.floorMod(other: Int): Int =
	when (other)
	{
		0 -> this
		else -> this - floorDiv(other) * other
	}

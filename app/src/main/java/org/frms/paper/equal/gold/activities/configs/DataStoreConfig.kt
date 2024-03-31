/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(DataStoreConfig.kt) is part of E纸千金.
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

package org.frms.paper.equal.gold.activities.configs

/**
 *本地界面存储
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/04/09 下午 10:38
 */
object DataStoreConfig
{
	const val DS_NORMAL = "ds_normal"

	// 是否是第一次使用/未注册 状态
	const val DS_INIT = "ds_init"

	// 手机号
	const val DS_PHONE = "ds_phone_number"

	// 新闻搜索历史
	const val DS_NEWS_HISTORY = "ds_news_history"

	// 商品搜索历史
	const val DS_GOODS_HISTORY = "ds_goods_history"

	// 分割历史记录
	const val DS_SPLIT = "sd_split"
}
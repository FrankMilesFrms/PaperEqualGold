/*
 * Copyright (C) 2023 - 2024 Frms, All Rights Reserved.
 *
 * This file(Utils.kt) is part of E纸千金.
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

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity


/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2023/03/25 下午 10:34
 */
object Utils
{
	fun showTextNumber(number: String): String =
		when (number.length)
		{
			in 0..3 -> number
			in 4..7 -> number.substring(0, 3) + " " + number.substring(3)
			else    -> number.substring(0, 3) + " " + number.substring(3, 7) + " " + number.substring(7)
		}

	fun Context.showToast(
		text: String,
		shot: Boolean = true
	): Unit
	{
		Toast.makeText(this, text, if (shot) Toast.LENGTH_SHORT else Toast.LENGTH_LONG).show()
	}

	fun Context.openURL(url: String)
	{
		val uri = Uri.parse(url)
		val intent = Intent()
		intent.action = "android.intent.action.VIEW"
		intent.data = uri
		startActivity(intent)
	}
}

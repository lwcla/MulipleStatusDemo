package com.cla.muliple.status.demo

import android.content.Context

/**
 * 单位转换: dp -> px
 *
 * @param dp
 * @return
 */
fun Context.dp2px(dp: Int): Int {
    return (resources.displayMetrics.density * dp + 0.5).toInt()
}

/**
 * 获取屏幕宽度
 *
 * @return
 */
fun Context.getScreenWidth(): Int {
    return resources.displayMetrics.widthPixels
}
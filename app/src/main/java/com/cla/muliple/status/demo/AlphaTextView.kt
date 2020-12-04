package com.cla.muliple.status.demo

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class AlphaTextView(context: Context, attr: AttributeSet? = null) :
    AppCompatTextView(context, attr) {

    override fun setPressed(pressed: Boolean) {
        super.setPressed(pressed)

        if (!isEnabled || !isClickable || !isFocusable) {
            return
        }

        val a = if (pressed) {
            0.5f
        } else {
            1f
        }

        alpha = a
    }

}
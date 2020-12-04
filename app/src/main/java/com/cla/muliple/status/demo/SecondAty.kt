package com.cla.muliple.status.demo

import android.annotation.SuppressLint
import com.cla.muliple.status.layout.MultipleStatusLayout
import kotlinx.android.synthetic.main.activity_second.*
import kotlin.concurrent.thread

class SecondAty : MultipleStatusBaseAty() {

    override fun getLayoutRes(): Int = R.layout.activity_second

    override fun customStatusLayout(rootView: MultipleStatusLayout) {
        rootView.useDefaultNoNetworkView(this, force = true)
    }

    override fun loadData() {
        thread {
            //模拟数据加载
            Thread.sleep(1500)
            //调这个方法去初始化ui
            runOnUiThread { rootView.showContent() }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun initView() {
        tv2.text = "调用showError方法"
        tv2.setOnClickListener {
//            Toast.makeText(this, "点击有效", Toast.LENGTH_SHORT).show()
            //如果当前已经是showContent状态中，那么这里无论调多少次都无效
            rootView.showError()
        }

        tv3.text = "强制调用showError方法"
        tv3.setOnClickListener {
            //强制显示
            //即使当前是showContent状态，也会切换到error状态
            rootView.showError(force = true)
        }

        tv4.text = "强制调用showEmpty方法"
        tv4.setOnClickListener {
            //强制显示
            //即使当前是showContent状态，也会切换到empty状态
            rootView.showEmpty(force = true)
        }

        tv5.text = "强制调用showNoNetwork方法"
        tv5.setOnClickListener {
            //强制显示
            //即使当前是showContent状态，也会切换到noNetwork状态
            rootView.showNoNetwork(true)
        }
    }
}
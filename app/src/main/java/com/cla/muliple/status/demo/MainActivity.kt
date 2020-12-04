package com.cla.muliple.status.demo

import android.annotation.SuppressLint
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : MultipleStatusBaseAty() {

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onResume() {
        super.onResume()
        rootView.reLoadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (rootView.contentViewShowed) {
            //如果要对ui做一些操作的话，要先做这个判断，否则会空指针
        }
    }

    override fun loadData() {
        thread {
            //模拟数据加载
            Thread.sleep(1500)
            //调showContent方法去初始化ui
            runOnUiThread { rootView.showContent() }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun initView() {
        textView.text = "到SecondAty"

        textView.setOnClickListener {
            startActivity(Intent(this, SecondAty::class.java))
        }
    }
}
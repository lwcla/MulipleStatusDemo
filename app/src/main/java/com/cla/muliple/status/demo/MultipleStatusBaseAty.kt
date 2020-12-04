package com.cla.muliple.status.demo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children

import com.cla.muliple.status.layout.MultipleStatusLayout

abstract class MultipleStatusBaseAty : AppCompatActivity() {

    protected val rootView: MultipleStatusLayout by lazy {
        MultipleStatusLayout(this).apply {
            contentViewLayoutId = getLayoutRes()
            emptyViewLayoutId = R.layout.layout_data_empty_new
            loadViewLayoutId = R.layout.layout_loading_new
            errorViewLayoutId = R.layout.layout_load_failure_new
            noNetworkViewLayoutId = R.layout.layout_no_network_new
            loadData = { loadData() }
            initView = { initView() }
            initLoadView = { initOtherTitleBar(it, "正在加载") }
            initEmptyView = { initOtherTitleBar(it, "提示") }
            initErrorView = { initOtherTitleBar(it, "提示") }
            initNoNetworkView = { initOtherTitleBar(it, "提示") }
            setBackgroundResource(bgColorRes)
            customStatusLayout(this)
            showLoading(
                force = true,
                needLoadData = needLoadData(),
                delayToLoadData = delayToLoadData()
            )
        }
    }

    //为了统一背景色和标题栏的颜色
    protected val bgColorRes = R.color.c9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(rootView)

        //设置状态栏颜色
//        QMUIStatusBarHelper.translucent(this, bgColorRes)
//        QMUIStatusBarHelper.setStatusBarLightMode(this)
    }

    /**
     * 初始化其中布局中的标题
     */
    protected fun initOtherTitleBar(view: View, title: String) {
        val layout = view as? ViewGroup? ?: return
        val titleBar = layout.children.find { it is SimpleTitleBar } as? SimpleTitleBar? ?: return
        titleBar.setTitle(title)
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int
    abstract fun loadData()
    abstract fun initView()

    /**
     * 延迟去加载数据的时间
     * 如果不想延迟就设置为0
     */
    open fun delayToLoadData() = 0L

    /**
     *  对MultipleStatusLayout添加一些自己的设置
     */
    open fun customStatusLayout(rootView: MultipleStatusLayout) {

    }

    open fun needLoadData() = true
}
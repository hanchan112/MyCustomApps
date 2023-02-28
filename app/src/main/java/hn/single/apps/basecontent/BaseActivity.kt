package hn.single.apps.basecontent

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController

abstract class BaseActivity : AppCompatActivity() {

    abstract fun activityNavController(): NavController?

    abstract fun initView()

    abstract fun initLayoutId(): Int

    abstract fun getLoadingId(): View?

    fun showLoadingProgress(isShow: Boolean) {
        if (isShow) {
            getLoadingId().show()
        } else {
            getLoadingId().gone()
        }
    }

    fun View?.show() {
        this?.visibility = View.VISIBLE
    }

    fun View?.gone() {
        this?.visibility = View.GONE
    }

    fun View?.invisible() {
        this?.visibility = View.INVISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        //}
        setContentView(initLayoutId())
        initView()
    }
}
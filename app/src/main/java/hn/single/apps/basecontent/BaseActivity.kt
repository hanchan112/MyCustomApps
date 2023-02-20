package hn.single.apps.basecontent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController

abstract class BaseActivity : AppCompatActivity() {

    abstract fun activityNavController(): NavController?

    abstract fun initView()

    abstract fun initLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayoutId())
        initView()
    }
}
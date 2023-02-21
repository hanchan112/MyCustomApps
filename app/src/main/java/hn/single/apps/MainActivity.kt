package hn.single.apps

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import hn.single.apps.basecontent.BaseActivity

class MainActivity : BaseActivity() {

    private var mNavController: NavController? = null

    override fun activityNavController(): NavController? {
        return mNavController
    }

    override fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        mNavController = navHostFragment.navController
    }

    override fun initLayoutId(): Int {
        return R.layout.activity_main
    }
}
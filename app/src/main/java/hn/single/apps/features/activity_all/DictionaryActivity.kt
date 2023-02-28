package hn.single.apps.features.activity_all

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import hn.single.apps.R
import hn.single.apps.basecontent.BaseActivity

class DictionaryActivity : BaseActivity() {

    private var mNavController: NavController? = null

    override fun activityNavController(): NavController? {
        return mNavController
    }

    override fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.containerDictionary) as NavHostFragment
        mNavController = navHostFragment.navController
    }

    override fun initLayoutId(): Int = R.layout.activity_dictionary

    override fun getLoadingId(): View? = findViewById(R.id.loadingView)

}
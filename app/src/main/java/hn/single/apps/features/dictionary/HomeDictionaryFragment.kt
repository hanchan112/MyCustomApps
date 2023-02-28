package hn.single.apps.features.dictionary

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import hn.single.apps.R
import hn.single.apps.basecontent.BaseFragment
import hn.single.apps.basecontent.Logger
import hn.single.apps.databinding.FragmentHomeDictionaryBinding
import hn.single.apps.features.common.Constants


class HomeDictionaryFragment : BaseFragment<FragmentHomeDictionaryBinding>(
    FragmentHomeDictionaryBinding::inflate
) {

    private var transAdapter: TransDictionaryAdapter? = null

    override var isNeedShowLoading: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transAdapter = TransDictionaryAdapter(childFragmentManager, lifecycle)
        binding.viewPagerTrans.adapter = transAdapter


        actionChangeTabPosition()
        binding.tabLayoutTrans.selectTab(binding.tabLayoutTrans.getTabAt(Constants.POSITION_0))
    }

    override fun initData(data: Bundle?) {}

    override fun initViews() {
        val tabLayoutMediator = createTabLayoutMediator()
        tabLayoutMediator.attach()
    }

    override fun initActions() {
        binding.textTransType.setOnClickListener {
            Logger.d("Click text trans")
            transAdapter?.setDatList(ModeTranslate.MODE_FIRST)
        }
    }

    private fun createTabLayoutMediator() =
        TabLayoutMediator(binding.tabLayoutTrans, binding.viewPagerTrans) { tab, position ->
            styleForTextOfTabSelected(tab, R.font.roboto_medium)
            when (position) {
                Constants.POSITION_0 -> {
                    tab.text = getString(R.string.trans_title_sentence)
                }
                Constants.POSITION_1 -> {
                    tab.text = getString(R.string.sub_title_movie)
                }
                Constants.POSITION_2 -> {
                    tab.text = getString(R.string.trans_title_image)
                }
            }
        }

    private fun actionChangeTabPosition() {
        binding.tabLayoutTrans.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                styleForTextOfTabSelected(tab, R.font.roboto_medium)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                styleForTextOfTabSelected(tab, R.font.roboto_regular)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                styleForTextOfTabSelected(tab, R.font.roboto_medium)
            }
        })
    }

    private fun styleForTextOfTabSelected(tab: TabLayout.Tab?, font: Int) {
        val tabLayout: ViewGroup? =
            tab?.position?.let {
                (binding.tabLayoutTrans.getChildAt(Constants.POSITION_0) as ViewGroup).getChildAt(it)
            } as ViewGroup?
        val tabTextView = tabLayout?.getChildAt(Constants.POSITION_1) as TextView?
        tabTextView?.typeface = ResourcesCompat.getFont(requireActivity(), font)
    }
}
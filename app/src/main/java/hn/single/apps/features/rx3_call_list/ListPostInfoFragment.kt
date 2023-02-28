package hn.single.apps.features.rx3_call_list

import hn.single.apps.base_content.BaseContentFragment
import hn.single.apps.databinding.FragmentListPostInfoBinding


class ListPostInfoFragment :
    BaseContentFragment<FragmentListPostInfoBinding, ListPostInfoRXViewModel>() {

    override var useSharedViewModel: Boolean = false

    companion object {
        @JvmStatic
        fun newInstance() =
            ListPostInfoFragment().apply { }
    }

    override fun getViewModelClass(): Class<ListPostInfoRXViewModel> {
        return ListPostInfoRXViewModel::class.java
    }

    override fun getViewBinding(): FragmentListPostInfoBinding {
        return FragmentListPostInfoBinding.inflate(layoutInflater)
    }

    override fun useSharedViewModel(): Boolean {
        return false
    }

    override fun setUpViews() {

    }

    override fun observeView() {

    }

    override fun observeData() {

    }
}
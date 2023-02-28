package hn.single.apps.features.dictionary

import android.os.Bundle
import hn.single.apps.basecontent.BaseFragment
import hn.single.apps.databinding.FragmentSubTitleMovieBinding

class SubTitleMovieFragment :
    BaseFragment<FragmentSubTitleMovieBinding>(FragmentSubTitleMovieBinding::inflate) {

    override var isNeedShowLoading: Boolean = false

    override fun initData(data: Bundle?) {}

    override fun initViews() {}

    override fun initActions() {}

    companion object {
        @JvmStatic
        fun newInstance() = SubTitleMovieFragment().apply { }
    }
}
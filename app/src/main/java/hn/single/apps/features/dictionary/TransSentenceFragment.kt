package hn.single.apps.features.dictionary

import android.os.Bundle
import hn.single.apps.basecontent.BaseFragment
import hn.single.apps.databinding.FragmentTransSentenceBinding


class TransSentenceFragment :
    BaseFragment<FragmentTransSentenceBinding>(FragmentTransSentenceBinding::inflate) {

    override var isNeedShowLoading: Boolean = false

    override fun initData(data: Bundle?) {}

    override fun initViews() {}

    override fun initActions() {}

    companion object {

        @JvmStatic
        fun newInstance() = TransSentenceFragment().apply {}
    }
}
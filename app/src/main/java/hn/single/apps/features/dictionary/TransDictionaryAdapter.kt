package hn.single.apps.features.dictionary

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TransDictionaryAdapter(
    fragmentManager: FragmentManager,
    lifeCycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifeCycle) {

    private val fragmentTrans: Fragment = TransSentenceFragment.newInstance()
    private val fragmentSub: Fragment = SubTitleMovieFragment.newInstance()
    private val fragmentImage: Fragment = ImageTransFragment.newInstance()

    private var mListFragmentInit = mutableListOf(fragmentTrans, fragmentSub, fragmentImage)
    private var mListFragmentDisplay = mutableListOf(fragmentTrans, fragmentSub, fragmentImage)

    fun setDatList(modeTranslate: ModeTranslate) {
        mListFragmentDisplay = when (modeTranslate) {
            ModeTranslate.MODE_FIRST -> mutableListOf(mListFragmentInit[0])
            ModeTranslate.MODE_SECOND -> mutableListOf(mListFragmentInit[0], mListFragmentInit[1])
            ModeTranslate.MODE_THIRD -> mListFragmentInit
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = mListFragmentDisplay.size

    override fun createFragment(position: Int): Fragment {
        return mListFragmentDisplay[position]
    }
}
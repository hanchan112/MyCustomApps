package hn.single.apps.features.retrofit_coroutines_list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import hn.single.apps.basecontent.BaseFragment
import hn.single.apps.basecontent.Logger
import hn.single.apps.databinding.FragmentPostBinding

class ListPostFragment : BaseFragment<FragmentPostBinding>(FragmentPostBinding::inflate) {

    private lateinit var mViewModel: ListPostViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(viewModelStore, vmFactory)[ListPostViewModel::class.java]

        mViewModel.fetchListPostItem()
        mViewModel.response.observe(viewLifecycleOwner) {
            if (it.isSuccessful) {
                Logger.d("List content: ${it.body()}")
            } else {
                Logger.d("Loi")
            }
        }


    }

}
package hn.single.apps.features.retrofit_coroutines

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import hn.single.apps.basecontent.BaseFragment
import hn.single.apps.basecontent.Logger
import hn.single.apps.databinding.FragmentPostBinding
import hn.single.apps.features.common.PlaceHolderRepository
import hn.single.apps.features.common.ViewModelFactory

class PostFragment : BaseFragment<FragmentPostBinding>(FragmentPostBinding::inflate) {

    private lateinit var mViewModel: PostFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val vmFactory = ViewModelFactory(PlaceHolderRepository())
        mViewModel =
            ViewModelProvider(viewModelStore, vmFactory).get(PostFragmentViewModel::class.java)
        mViewModel.fetchPostItem()
        showLoadingProgress(true)
        mViewModel.response.observe(viewLifecycleOwner) { response ->
            showLoadingProgress(false)
            if (response.isSuccessful) {
                binding.textName.text = response.body().toString()
                Logger.d("Data receive: == ${response.body()}")
            } else {
                Logger.d("Error receive: == ${response.errorBody()}")
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PostFragment().apply {}

    }
}
package hn.single.apps

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import hn.single.apps.basecontent.BaseFragment
import hn.single.apps.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.consCommon1.setOnClickListener {
            showSuccessMessage("Test success", "Noi dung thong bao")
        }
        binding.consCommon2.setOnClickListener {
            showErrorMessage("Test error", "Noi dung loi")
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment().apply { }
    }
}
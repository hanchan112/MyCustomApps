package hn.single.apps

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import hn.single.apps.basecontent.BaseFragment
import hn.single.apps.databinding.FragmentHomeBinding
import hn.single.apps.features.activity_all.DictionaryActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val mainDispatcher = Dispatchers.Main + Job()

    override var isNeedShowLoading: Boolean = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(mainDispatcher).launch {
            delay(100)
        }

    }

    override fun initData(data: Bundle?) {
        //Suppress
    }

    override fun initViews() {}

    override fun initActions() {
        binding.img1.setOnClickListener {
            showSuccessMessage("Test success", "Noi dung thong bao")
            fragmentNavController()?.navigate(R.id.postFragment)
        }
        binding.img2.setOnClickListener {
            showErrorMessage("Test error", "Noi dung loi")
            fragmentNavController()?.navigate(R.id.listPostFragment)
        }
        binding.img3.setOnClickListener {
            startActivity(Intent(requireActivity(), DictionaryActivity::class.java))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment().apply { }
    }
}
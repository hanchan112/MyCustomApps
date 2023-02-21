package hn.single.apps.basecontent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding

/**
 * A simple base fragment.
 *
 */

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(private val layoutInflater: Inflate<VB>) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = layoutInflater.invoke(inflater, container, false)
        return _binding?.root
    }

    fun fragmentNavController(): NavController? {
        return (activity as? BaseActivity)?.activityNavController()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
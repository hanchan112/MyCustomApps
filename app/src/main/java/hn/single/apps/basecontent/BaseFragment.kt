package hn.single.apps.basecontent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding
import hn.single.apps.R
import hn.single.apps.features.common.PlaceHolderRepository
import hn.single.apps.features.common.ViewModelFactory

/**
 * A simple base fragment.
 *
 */

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val layoutInflater: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    protected lateinit var vmFactory: ViewModelFactory
    val binding get() = _binding!!
    var notifyDialog: NotifyCommonDialog? = null
    open var isNeedShowLoading = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = layoutInflater.invoke(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.d("isNeedShowLoading == $isNeedShowLoading")
        if (isNeedShowLoading) {
            showLoadingProgress(true)
        }
        vmFactory = ViewModelFactory(PlaceHolderRepository())
        initData(arguments)
        initViews()
        initActions()
    }


    abstract fun initData(data : Bundle?)

    abstract fun initViews()

    abstract fun initActions()


    fun fragmentNavController(): NavController? {
        return (activity as? BaseActivity)?.activityNavController()
    }

    fun showLoadingProgress(isShow: Boolean) {
        (activity as BaseActivity).showLoadingProgress(isShow)
    }

    fun View?.show() {
        this?.visibility = View.VISIBLE
    }

    fun View?.gone() {
        this?.visibility = View.GONE
    }

    fun View?.invisible() {
        this?.visibility = View.INVISIBLE
    }

    open fun showToastMessage(
        title: String,
        description: String? = null,
        @DrawableRes background: Int = R.drawable.notify_error_dialog_base,
        @DrawableRes iconClose: Int = R.drawable.ic_close_notify_base_error,
        @DrawableRes image: Int = R.drawable.img_notify_base_error,
        duration: Long = 5_000L
    ) {
        notifyDialog?.dismiss()
        notifyDialog = activity?.let {
            NotifyCommonDialog(
                context = it,
                titleDialog = title,
                contentDialog = description,
                imageDialog = image,
                iconCloseDialog = iconClose,
                imgBackground = background,
                timeExist = duration
            )
        }
        activity?.let {
            notifyDialog?.show()
        }
    }

    fun showErrorMessage(
        title: String,
        description: String? = null,
        duration: Long = 5_000L
    ) {
        notifyDialog?.dismiss()
        notifyDialog = activity?.let {
            NotifyCommonDialog(
                context = it,
                titleDialog = title,
                contentDialog = description,
                imageDialog = R.drawable.img_notify_base_error,
                iconCloseDialog = R.drawable.ic_close_notify_base_error,
                imgBackground = R.drawable.notify_error_dialog_base,
                timeExist = duration
            )
        }
        activity?.let {
            notifyDialog?.show()
        }
    }

    fun showSuccessMessage(
        title: String,
        description: String? = null,
        duration: Long = 5_000L
    ) {
        notifyDialog?.dismiss()
        notifyDialog = activity?.let {
            NotifyCommonDialog(
                context = it,
                titleDialog = title,
                contentDialog = description,
                imageDialog = R.drawable.img_notify_base_sucess,
                iconCloseDialog = R.drawable.ic_close_notify_base_success,
                imgBackground = R.drawable.notify_success_dialog_base,
                timeExist = duration
            )
        }
        activity?.let {
            notifyDialog?.show()
        }
    }

    fun cancelNotifyCommon() = notifyDialog?.dismiss()

    override fun onDestroyView() {
        super.onDestroyView()
        cancelNotifyCommon()
        _binding = null
    }

}
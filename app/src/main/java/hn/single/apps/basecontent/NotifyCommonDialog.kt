package hn.single.apps.basecontent

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import hn.single.apps.R
import hn.single.apps.databinding.CommonNotifyBaseBinding


class NotifyCommonDialog(
    context: Context,
    private var titleDialog: String? = Constants.EMPTY_STRING,
    private var contentDialog: String? = null,
    private var imageDialog: Int = R.drawable.img_notify_base_error,
    private var iconCloseDialog: Int = R.drawable.ic_close_notify_base_error,
    private var imgBackground: Int = R.drawable.notify_error_dialog_base,
    private var timeExist: Long = 5000L,
    val timeInterval: Long = 1000L
) : Dialog(context, R.style.DialogFullSize) {

    private var dialogBinding: CommonNotifyBaseBinding? = null

    private val timer = object: CountDownTimer(timeExist, timeInterval) {
        override fun onTick(millisUntilFinished: Long) {
            //Suppress
        }

        override fun onFinish() {
            dismiss()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        transparentLayoutRoot()
        window?.setGravity(Gravity.TOP)
        keepLayoutPosition()
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        dialogBinding = CommonNotifyBaseBinding.inflate(layoutInflater)
        //setContentView(R.layout.common_notify_base)
        dialogBinding?.root?.let { setContentView(it) }
        permitClickBelow()
        hideViewsNull()
        initTextImageForLayout()
        actionCloseButton()
        setCancelable(false)
        autoCloseDialog()
    }

    private fun transparentLayoutRoot() {
        val windowParams: WindowManager.LayoutParams? = window?.attributes
        windowParams?.dimAmount = 0.0f
        window?.attributes = windowParams
    }

    private fun keepLayoutPosition() {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    private fun permitClickBelow() {
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        )
        window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    private fun hideViewsNull() {
        if (titleDialog == null) {
            dialogBinding?.titleNotifyBase?.visibility = View.GONE
        } else {
            dialogBinding?.titleNotifyBase?.visibility = View.VISIBLE
        }
        if (contentDialog == null) {
            dialogBinding?.contentNotifyBase?.visibility = View.GONE
        } else {
            dialogBinding?.contentNotifyBase?.visibility = View.VISIBLE
        }
    }

    private fun initTextImageForLayout() {
        dialogBinding?.titleNotifyBase?.text = titleDialog
        dialogBinding?.contentNotifyBase?.text = contentDialog
        dialogBinding?.imgNotifyBase?.setImageResource(imageDialog)
        dialogBinding?.commonNotifyCloseBase?.setImageResource(iconCloseDialog)
        dialogBinding?.consNotifyBase?.setBackgroundResource(imgBackground)
    }

    private fun actionCloseButton() {
        dialogBinding?.commonNotifyCloseBase?.setOnClickListener {
            dismiss()
        }
    }

    private fun autoCloseDialog() {
        timer.start()
    }

    fun resetAutoCloseTimer(){
        timer.cancel()
        timer.start()
    }
}
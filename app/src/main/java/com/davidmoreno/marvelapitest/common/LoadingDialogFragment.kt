package com.davidmoreno.marvelapitest.common


import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.davidmoreno.marvelapitest.R

/**
 * A [DialogFragment] subclass.
 */
class LoadingDialogFragment : DialogFragment() {

    /** Loading dialog view creation */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_loading_dialog, container, false)
    }

    /** Open Loading dialog */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // the content
        val root = RelativeLayout(activity)
        root.layoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        // creating the fullscreen dialog
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        dialog.window!!.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(requireContext(), R.color.fragment_loading_dialog_background)
            )
        )
        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        return dialog
    }

    /** Loading dialog instance */
    fun newInstance(): LoadingDialogFragment {
        return LoadingDialogFragment()
    }

}

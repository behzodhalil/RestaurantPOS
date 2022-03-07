package uz.behzoddev.restaurantpos.view.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.databinding.DialogOrderConfirmBinding

class OrderConfirmDialog : DialogFragment() {

    private var _binding: DialogOrderConfirmBinding? = null
    private val binding: DialogOrderConfirmBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogOrderConfirmBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setOnShowListener {
            dialog?.window?.setLayout(
                550,
                400
            )
        }
        confirm()
    }

    override fun getTheme(): Int {
        return R.style.RoundedCornersDialog
    }
    private fun confirm() {
        binding.tvNoticeConfirm.setOnClickListener {
            dismiss()
        }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }

}


package com.sovonthy.tshop.view.notification.complete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.sovonthy.tshop.R
import com.sovonthy.tshop.databinding.FragmentNotificationCompleteBinding

class NotificationCompleteFragment : Fragment() {

    private var _binding: FragmentNotificationCompleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationCompleteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionView()
    }

    private fun initActionView(){
        binding.clickButton.setOnClickListener {
            val navController = requireActivity().findNavController(R.id.notification_fragment_container)
            navController.navigate(R.id.action_notificationFragment2_to_notificationDetailFragment)
        }

    }

}
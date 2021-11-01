package com.sovonthy.tshop.view.notification

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign
import com.sovonthy.tshop.R
import com.sovonthy.tshop.databinding.FragmentNotificationBinding
import com.sovonthy.tshop.helper.KeepStateNavigator

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val statusNavHostFragment =
            childFragmentManager.findFragmentById(R.id.notification_status_fragment_container) as NavHostFragment
        val statusController = statusNavHostFragment.navController
        val statusNavigator = KeepStateNavigator(
            requireContext(),
            statusNavHostFragment.childFragmentManager,
            R.id.notification_status_fragment_container
        )
        statusController.navigatorProvider += statusNavigator
        statusController.setGraph(R.navigation.notification_status_container)

        initActionView()
    }

    private fun initActionView() {
//        binding.icMenu.setOnClickListener {
//            val nestedNavHostFragment =
//                requireActivity().supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//            val mainNavController = nestedNavHostFragment.navController
//            mainNavController.navigate(R.id.action_mainActivity_to_menuFragment)
//        }
        binding.completeLayout.setOnClickListener {
            Navigation.findNavController(
                requireActivity(),
                R.id.notification_status_fragment_container
            )
                .navigate(R.id.notificationCompleteFragment)
        }
        binding.cancelLayout.setOnClickListener {

            Navigation.findNavController(
                requireActivity(),
                R.id.notification_status_fragment_container
            )
                .navigate(R.id.notification_Cancel_Fragment)
        }
    }


}
package com.sovonthy.tshop.view.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.sovonthy.tshop.R
import com.sovonthy.tshop.databinding.FragmentCardBinding

class ProductFragment : Fragment() {
    private var _binding: FragmentCardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CategoryViewModel by activityViewModels()
    private val productModel: ProductViewModel by activityViewModels()

    private val controller: ProductController by lazy {
        ProductController(
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe()
    }

    private fun initView() {
        binding.icMenu.setOnClickListener {
            requireActivity().findViewById<DrawerLayout>(R.id.drawerLayout).openDrawer(GravityCompat.START)
        }

        val linearLayoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.setController(controller = controller)
        binding.recyclerView.requestModelBuild()
    }

    private fun observe(){
        viewModel.categories.observe(viewLifecycleOwner, {
             controller.submitCategory(list = it)
        })
        productModel.products.observe(viewLifecycleOwner, {
            controller.submitProduct(list = it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
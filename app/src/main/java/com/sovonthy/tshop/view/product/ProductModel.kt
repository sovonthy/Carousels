package com.sovonthy.tshop.view.product


import android.annotation.SuppressLint
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.sovonthy.tshop.R
import com.sovonthy.tshop.databinding.ComponentProductItemBinding

@EpoxyModelClass(layout = R.layout.component_product_item)
abstract class ProductModel : EpoxyModelWithHolder<ProductModel.ProductHolder>() {

    @field:EpoxyAttribute
    var productId: Int? = null

    @field:EpoxyAttribute
    var imageProduct: String? = null

    @field:EpoxyAttribute
    var nameProduct: String? = null

    @field:EpoxyAttribute
    var priceProduct: String? = null

    @field:EpoxyAttribute
    var addProduct: Boolean? = null

    @SuppressLint("SetTextI18n")
    override fun bind(holder: ProductHolder) {
        super.bind(holder)
        holder.binding.productNameTextView.text = nameProduct
        holder.binding.priceTextView.text = priceProduct
        Glide.with(holder.binding.productImageView)
            .load(imageProduct)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.productImageView)
    }

    class ProductHolder : EpoxyHolder() {
        lateinit var binding: ComponentProductItemBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentProductItemBinding.bind(itemView)
        }
    }
}


package com.sovonthy.tshop.view.product

import android.annotation.SuppressLint
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sovonthy.tshop.R
import com.sovonthy.tshop.databinding.ComponentCategoryItemBinding

@EpoxyModelClass(layout = R.layout.component_category_item)
abstract class CategoryModel : EpoxyModelWithHolder<CategoryModel.CategoryHolder>() {

    @field:EpoxyAttribute
    var productId: Int? = null

    @field:EpoxyAttribute
    var categoryName: String? = null

    @field:EpoxyAttribute
    var background: Int? = null

    @field:EpoxyAttribute
    var selected: Boolean? = null

    @EpoxyAttribute
    lateinit var clickListener: () -> Unit

    @SuppressLint("SetTextI18n")
    override fun bind(holder: CategoryHolder) {
        super.bind(holder)
        holder.binding.nameCategoryTextView.text = categoryName
        holder.binding.root.setBackgroundResource(background!!)
        holder.binding.root.setOnClickListener {
            clickListener()
        }
    }

    class CategoryHolder : EpoxyHolder() {
        lateinit var binding: ComponentCategoryItemBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentCategoryItemBinding.bind(itemView)
        }
    }
}


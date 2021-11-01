package com.sovonthy.tshop.view.product

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.sovonthy.tshop.R
import com.sovonthy.tshop.model.Category
import com.sovonthy.tshop.model.Product
import java.util.concurrent.CopyOnWriteArrayList

class ProductController() : EpoxyController() {

    private var categories: CopyOnWriteArrayList<Category> = CopyOnWriteArrayList()
    private var selectCategory: Category? = null
    private var products: CopyOnWriteArrayList<Product> = CopyOnWriteArrayList()

    fun submitCategory(list: ArrayList<Category>) {
        categories.clear()
        categories.addAll(list)
        requestModelBuild()
    }

    fun submitProduct(list: ArrayList<Product>) {
        products.clear()
        products.addAll(list)
        requestModelBuild()
    }

    override fun buildModels() {
        val carouselList: ArrayList<CategoryModel_> = ArrayList()
        categories.forEach { item ->
            carouselList.add(
                CategoryModel_()
                    .id(item.id)
                    .categoryName(item.name)
                    .background(
                        if (item.selected) {
                            R.drawable.background_border_selected
                            R.color.teal_700
                        } else {
                            R.drawable.background_border
                            R.color.light_blue
                        }
                    )
                    .selected(item.selected)
                    .clickListener {
                        if (this@ProductController.selectCategory != null) {
                            this@ProductController.selectCategory?.selected = false
                        }
                        item.selected = !item.selected
                        if (item.id != this@ProductController.selectCategory?.id) {
                            this@ProductController.selectCategory = item
                        }
                        this@ProductController.requestModelBuild()
                    }
            )
        }

        carousel {
            id("carousel")
            models(carouselList)
//            numViewsToShowOnScreen(2f)
        }

        products.forEach { item ->
            product {
                id(item.productId)
                nameProduct(item.productName)
                imageProduct(item.productImage)
                priceProduct(item.productPrice)
            }
        }

    }
}

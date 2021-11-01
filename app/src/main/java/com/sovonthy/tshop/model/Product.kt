package com.sovonthy.tshop.model

data class Product(
    var productId: Int,
    var productImage: String,
    var productName: String,
    var productPrice: String,
    var addProduct: Boolean
)

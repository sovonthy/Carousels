package com.sovonthy.tshop.view.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sovonthy.tshop.model.Category

class CategoryViewModel : ViewModel() {

    val categories: MutableLiveData<ArrayList<Category>> = MutableLiveData(ArrayList())
    private val tempBudgets: ArrayList<Category> = ArrayList()

    init {
        if(categories.value?.isEmpty() == true) {
            val list = arrayListOf(
                Category(1, "Happy Meal", false),
                Category(2, "Burgers & Wraps", false),
                Category(3, "Breakfast", false),
                Category(4, "Happy Meal", false),
                Category(5, "Desert", false),
            )
            if (categories.value?.isEmpty()!!) {
                tempBudgets.addAll(list)
                categories.postValue(tempBudgets)
            }
        }

    }

}
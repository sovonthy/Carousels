package com.sovonthy.tshop.view.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    val selectedTabStatus: MutableLiveData<Int> = MutableLiveData(1)
    val menuIndex: MutableLiveData<Int> = MutableLiveData(1)

    fun setIndex(newIndex: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            selectedTabStatus.postValue(newIndex)
        }
    }

    fun menu(value: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            menuIndex.postValue(value)
        }
    }

}
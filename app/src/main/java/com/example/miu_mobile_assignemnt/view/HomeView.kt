package com.example.miu_mobile_assignemnt.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeView : ViewModel() {
    private val _title = MutableLiveData<String>().apply {
        value = "Final hard task of mobile app with database: I had problem with initializing my room base, if you click garden menu it will throw error. I will look that up in upcoming pre"
    }
    private val _text = MutableLiveData<String>().apply {
        value = "My home"
    }
    val title: LiveData<String> = _title
    val text: LiveData<String> = _text
}
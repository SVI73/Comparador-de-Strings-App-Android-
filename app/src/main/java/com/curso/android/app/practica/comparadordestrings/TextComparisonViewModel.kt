package com.curso.android.app.practica.comparadordestrings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextComparisonViewModel : ViewModel() {
    private val _comparisonResult = MutableLiveData<Boolean>()
    val comparisonResult: LiveData<Boolean> = _comparisonResult

    fun compareTexts(text1: String, text2: String) {
        _comparisonResult.value = text1 == text2
    }
}
package com.example.jackofallapp.featureShowGrob.presentation.grobbies

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jackofallapp.featureShowGrob.domain.models.Grobbies
import com.example.jackofallapp.featureShowGrob.domain.models.Grobby

class GrobbiesViewModel : ViewModel() {
    private val _grobbyList = mutableStateOf(Grobbies)

    var grobbyList : List<Grobby>
        get() {
            return _grobbyList.value
        }
        set(value) {
            _grobbyList.value = value
        }
}
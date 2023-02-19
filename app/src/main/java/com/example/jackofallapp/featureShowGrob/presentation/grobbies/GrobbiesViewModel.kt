package com.example.jackofallapp.featureShowGrob.presentation.grobbies

import androidx.compose.runtime.MutableState
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

    private val _showDialog  = mutableStateOf(false)
    var showDialog : Boolean
        get() {
            return _showDialog.value
        }
        set(value) {
            _showDialog.value = value
        }
    fun onAddGrobby(grobby: Grobby){
        grobbyList += Grobby(grobby.name, grobby.age)
    }

    fun onDialogConfirm(){
       showDialog = false;
    }

    fun onDialogDismiss(){
        showDialog = false;
    }
}
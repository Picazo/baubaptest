package com.baubaptest.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baubaptest.data.repository.BaubapRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaubapViewModel @Inject constructor(
    private val repository: BaubapRepository
)  : ViewModel(){

    private val _loginUser = MutableLiveData <Boolean> ()
    val userLogin :LiveData<Boolean> get () = _loginUser

    fun loginUser(){
        viewModelScope.launch {
            val response = repository.getSomeStuffs()
            _loginUser.postValue(response)
        }
    }

}
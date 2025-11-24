package com.rindra.firebaseservice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rindra.firebaseservice.repository.PromptRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel(){
    private val promptRepository = PromptRepository()

    private val _loading = MutableLiveData<Boolean>(false);
    val loading: LiveData<Boolean> = _loading;

    private val _response = MutableLiveData<String?>(null);
    val response: LiveData<String?> = _response

    fun generateContent(){
        _loading.postValue(true)
        viewModelScope.launch {
            val aiResponse = promptRepository.generateSuggestions()
            _response.postValue(aiResponse)
            _loading.postValue(false)
        }
    }
}
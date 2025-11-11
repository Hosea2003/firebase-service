package com.rindra.firebaseservice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel: ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    init {
        checkAuthStatus()
    }

    fun checkAuthStatus(){
        val user = auth.currentUser
        if(user==null){
            _authState.postValue(AuthState.Unauthenticated)
        }
        else{
            _authState.postValue(AuthState.Authenticated)
        }
    }

    fun signUp(email:String, password:String){
        _authState.postValue(AuthState.Loading)
        auth.createUserWithEmailAndPassword(
            email, password
        )
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    _authState.postValue(AuthState.Authenticated)
                }
                else{
                    _authState.postValue(AuthState.Error(
                        task.exception?.message?:"Something went wrong"
                    ))
                }
            }
    }

    fun login(email:String, password:String){
        _authState.postValue(AuthState.Loading)
        auth.signInWithEmailAndPassword(
            email, password
        )
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    _authState.postValue(AuthState.Authenticated)
                }
                else{
                    _authState.postValue(AuthState.Error(
                        task.exception?.message?:"Something went wrong"
                    ))
                }
            }
    }

    fun signOut(){
        auth.signOut()
        _authState.postValue(AuthState.Unauthenticated)
    }

}

sealed class AuthState{
    object Authenticated: AuthState()
    object Unauthenticated: AuthState()
    object Loading: AuthState()
    data class Error(val message:String): AuthState()
}
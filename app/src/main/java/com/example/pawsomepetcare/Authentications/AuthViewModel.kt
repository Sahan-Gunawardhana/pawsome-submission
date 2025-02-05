package com.example.pawsomepetcare.Authentications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class AuthViewModel {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    init {
        checkAuthStatus()
    }
    fun checkAuthStatus(){
        if(auth.currentUser == null){
            _authState.value = AuthState.UnAuthenticated
        }else{
            _authState.value = AuthState.Authenticated
        }
    }

    fun login(email:String, password:String){
        if(email.isEmpty() || password.isEmpty()){
            _authState.value = AuthState.Error("Email and password cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    _authState.value = AuthState.Authenticated
                }else{
                    val exception = task.exception
                    val errorMessage = when (exception){
                        is FirebaseAuthInvalidUserException -> "Email or Password is Incorrect"
                        is FirebaseAuthInvalidCredentialsException -> "Email or Password is Incorrect"
                        else -> exception?.message ?: "Something went Wrong"
                    }
                    _authState.value = AuthState.Error(errorMessage)
                }
            }
    }

    fun signUp(email:String, password: String){
        if(email.isEmpty() || password.isEmpty()){
            _authState.value = AuthState.Error("Email and password cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    val exception = task.exception
                    val errorMessage = when (exception) {
                        is FirebaseAuthInvalidUserException -> "Email or password is incorrect"
                        is FirebaseAuthInvalidCredentialsException -> "Email or password is incorrect"
                        else -> exception?.message ?: "Something went wrong"
                    }
                    _authState.value = AuthState.Error(errorMessage)
                }
            }
    }

    fun logout(){
        auth.signOut()
        _authState.value = AuthState.UnAuthenticated
    }
}

sealed class AuthState{
    object Authenticated : AuthState()
    object UnAuthenticated: AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}
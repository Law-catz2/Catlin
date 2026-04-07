package com.example.loginapp

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authMessage = MutableStateFlow<String?>(null)
    val authMessage: StateFlow<String?> = _authMessage

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        if (email.isBlank() || password.isBlank()) {
            _authMessage.value = "Please fill in all fields."
            return
        }
        _isLoading.value = true
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isLoading.value = false
                if (task.isSuccessful) onSuccess()
                else _authMessage.value = task.exception?.message ?: "Login failed."
            }
    }

    fun register(email: String, password: String, onSuccess: () -> Unit) {
        if(email.isBlank() || password.isBlank()) {
            _authMessage.value = "Please fill in all fields."
            return
        }
        if (password.length < 6) {
            _authMessage.value = "Password must be at least 6 characters."
            return
        }
        _isLoading.value = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isLoading.value = false
                if (task.isSuccessful) onSuccess()
                else _authMessage.value = task.exception?.message ?: "Registration failed."
            }
    }

    fun logout(onLogout: () -> Unit){
        auth.signOut()
        onLogout()
    }
    fun clearMessage() { _authMessage.value = null }
}
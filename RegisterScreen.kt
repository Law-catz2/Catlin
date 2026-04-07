package com.example.loginapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun RegisterScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel()
) {
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var confirmPassword by remember { mutableStateOf("")}
    val authMessage by authViewModel.authMessage.collectAsState()
    val isLoading by authViewModel.isLoading.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Create a new account",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it},
                label = { Text("Email")},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it},
                label = { Text("Password")},
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it},
                label = { Text("Confirm Password")},
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            authMessage?.let {
                Text(it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
            }

            Button(
                onClick = {
                    authViewModel.clearMessage()
                    authViewModel.register(email, password) {
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF23CB),
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ){
                if (isLoading) CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                ) else Text("Create Account")
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Already have an account? Login")
            }
        }
    }
}
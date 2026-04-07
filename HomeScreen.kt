package com.example.loginapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel()
) {
    val currentUser = FirebaseAuth.getInstance().currentUser
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                currentUser?.email ?: "Unknown user",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    authViewModel.logout{
                        navController.navigate("login") {
                            popUpTo("home") { inclusive = true}
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Logout")
            }

        }
    }


    /**/
}
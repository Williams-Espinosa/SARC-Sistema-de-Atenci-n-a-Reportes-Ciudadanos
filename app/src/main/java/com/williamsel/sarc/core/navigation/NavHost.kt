package com.williamsel.sarc.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.williamsel.sarc.core.session.AuthEventBus
import com.williamsel.sarc.core.session.SessionViewModel

@Composable
fun NavHost() {
    val navController = rememberNavController()

    // SessionManager se obtiene a través de un ViewModel inyectado por Hilt,
    // no directamente como parámetro en un @Composable sin ViewModel
    val sessionViewModel: SessionViewModel = hiltViewModel()
    val sessionManager = sessionViewModel.sessionManager

    LaunchedEffect(Unit) {
        AuthEventBus.events.collect { event ->
            when (event) {
                is AuthEventBus.AuthEvent.SessionExpired -> {
                    navController.navigate(NavController.Publico.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            }
        }
    }

    NavGraph(
        navController  = navController,
        sessionManager = sessionManager
    )
}

package com.williamsel.sarc.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.williamsel.sarc.core.session.AuthEventBus
import com.williamsel.sarc.core.session.SessionManager
import javax.inject.Inject

@Composable
fun NavHost(sessionManager: SessionManager) {
    val navController = rememberNavController()

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
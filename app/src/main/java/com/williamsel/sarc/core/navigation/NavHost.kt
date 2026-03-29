package com.williamsel.sarc.core.navigation

import NavGraph
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.williamsel.sarc.core.session.AuthEventBus

@Composable
fun NavHost(startDestination: String = NavController.Publico.Inicio.route) {
    val navController = rememberNavController()
    NavGraph(
        navController    = navController,
        startDestination = startDestination
    )
}
@Composable
fun SarcNavHost() {
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

    NavGraph(navController = navController)
}
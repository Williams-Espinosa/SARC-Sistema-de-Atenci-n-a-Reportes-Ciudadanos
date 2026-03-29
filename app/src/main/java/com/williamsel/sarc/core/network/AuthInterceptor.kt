package com.williamsel.sarc.core.network

import SessionManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import coil.intercept.Interceptor
import com.williamsel.sarc.core.navigation.NavController
import jakarta.inject.Inject
import okhttp3.Response

class AuthInterceptor @Inject constructor(
    private val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sessionManager.getToken()

        val request = if (token != null) {
            chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        } else {
            chain.request()
        }

        val response = chain.proceed(request)

        if (response.code == 401) {
            sessionManager.clearSession()
        }

        return response
    }
}
@Composable
fun GuardedRoute(
    requiredRol: String,
    sessionManager: SessionManager,
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    val rolActual = sessionManager.getRol()

    if (!sessionManager.isLoggedIn()) {
        LaunchedEffect(Unit) {
            navController.navigate(NavController.Publico.Login.route) {
                popUpTo(0) { inclusive = true }
            }
        }
        return
    }

    if (rolActual != requiredRol) {
        LaunchedEffect(Unit) {
            val destino = if (rolActual == "ADMIN")
                NavController.Admin.Panel.route
            else
                NavController.Ciudadano.Panel.route
            navController.navigate(destino) { popUpTo(0) { inclusive = true } }
        }
        return
    }

    content()
}
package com.williamsel.sarc.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.williamsel.sarc.core.session.SessionManager

import com.williamsel.sarc.features.publico.incio.presentacion.screens.InicioScreen
import com.williamsel.sarc.features.publico.login.presentacion.screens.LoginScreen
import com.williamsel.sarc.features.publico.terminosycondiciones.presentacion.screens.TerminosScreen
import com.williamsel.sarc.features.publico.politicasdeprivacidad.presentacion.screens.PrivacidadScreen
import com.williamsel.sarc.features.ciudadano.registro.presentacion.screens.RegistroScreen

import com.williamsel.sarc.features.ciudadano.panelciu.presentacion.screens.PanelCiudadanoScreen
import com.williamsel.sarc.features.ciudadano.mapaciu.presentacion.screens.MapaCiudadanoScreen
import com.williamsel.sarc.features.ciudadano.crearreportes.presentacion.screens.CrearReporteScreen
import com.williamsel.sarc.features.ciudadano.misreportesciu.presentacion.screens.MisReportesScreen

import com.williamsel.sarc.features.administrador.paneladmin.presentacion.screens.PanelAdminScreen
import com.williamsel.sarc.features.administrador.mapaadmin.presentacion.screens.MapaAdminScreen
import com.williamsel.sarc.features.administrador.reportesadmin.presentacion.screens.ReportesAdminScreen
import com.williamsel.sarc.features.administrador.estayrepoadmin.presentacion.screens.EstadoRepoAdminScreen
import com.williamsel.sarc.login.presentacion.screens.LoginScreen
import com.williamsel.sarc.presentacion.screens.InicioScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    sessionManager: SessionManager
) {
    val startDestination = when {
        !sessionManager.isLoggedIn()           -> NavController.Publico.Inicio.route
        sessionManager.getRol() == "ADMIN"     -> NavController.Admin.Panel.route
        sessionManager.getRol() == "CIUDADANO" -> NavController.Ciudadano.Panel.route
        else                                   -> NavController.Publico.Inicio.route
    }

    NavHost(
        navController    = navController,
        startDestination = startDestination
    ) {

        composable(AppRoutes.Publico.Inicio.route) {
            InicioScreen(
                onNavigateToLogin    = { navController.navigate(NavController.Publico.Login.route) },
                onNavigateToRegistro = { navController.navigate(NavController.Publico.Registro.route) }
            )
        }

        composable(NavController.Publico.Login.route) {
            LoginScreen(
                onLoginSuccess = { rol ->
                    val destino = if (rol == "ADMIN")
                        NavController.Admin.Panel.route
                    else
                        NavController.Ciudadano.Panel.route

                    navController.navigate(destino) {
                        popUpTo(NavController.Publico.Inicio.route) { inclusive = true }
                    }
                },
                onCrearCuenta  = { navController.navigate(NavController.Publico.Registro.route) },
                onVolverInicio = { navController.popBackStack() }
            )
        }

        composable(NavController.Publico.Registro.route) {
            RegistroScreen(
                onRegistroExitoso = {
                    navController.navigate(AppRoutes.Ciudadano.Panel.route) {
                        popUpTo(AppRoutes.Publico.Inicio.route) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(NavController.Publico.Terminos.route) {
            TerminosScreen(onBack = { navController.popBackStack() })
        }

        composable(NavController.Publico.Privacidad.route) {
            PrivacidadScreen(onBack = { navController.popBackStack() })
        }

        composable(NavController.Ciudadano.Panel.route) {
            GuardedRoute(
                requiredRol    = "CIUDADANO",
                sessionManager = sessionManager,
                navController  = navController
            ) {
                PanelCiudadanoScreen(
                    onNavigateToMapa         = { navController.navigate(AppRoutes.Ciudadano.Mapa.route) },
                    onNavigateToCrearReporte = { navController.navigate(AppRoutes.Ciudadano.CrearReporte.route) },
                    onNavigateToMisReportes  = { navController.navigate(AppRoutes.Ciudadano.MisReportes.route) },
                    onLogout = {
                        sessionManager.clearSession()
                        navController.navigate(AppRoutes.Publico.Inicio.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
            }
        }

        composable(NavController.Ciudadano.Mapa.route) {
            GuardedRoute(
                requiredRol    = "CIUDADANO",
                sessionManager = sessionManager,
                navController  = navController
            ) {
                MapaCiudadanoScreen(onBack = { navController.popBackStack() })
            }
        }

        composable(NavController.Ciudadano.CrearReporte.route) {
            GuardedRoute(
                requiredRol    = "CIUDADANO",
                sessionManager = sessionManager,
                navController  = navController
            ) {
                CrearReporteScreen(
                    onReporteCreado = { navController.popBackStack() },
                    onBack          = { navController.popBackStack() }
                )
            }
        }

        composable(NavController.Ciudadano.MisReportes.route) {
            GuardedRoute(
                requiredRol    = "CIUDADANO",
                sessionManager = sessionManager,
                navController  = navController
            ) {
                MisReportesScreen(onBack = { navController.popBackStack() })
            }
        }

        composable(NavController.Admin.Panel.route) {
            GuardedRoute(
                requiredRol    = "ADMIN",
                sessionManager = sessionManager,
                navController  = navController
            ) {
                PanelAdminScreen(
                    onNavigateToMapa     = { navController.navigate(AppRoutes.Admin.Mapa.route) },
                    onNavigateToReportes = { navController.navigate(AppRoutes.Admin.Reportes.route) },
                    onNavigateToEstado   = { navController.navigate(AppRoutes.Admin.EstadoRepo.route) },
                    onLogout = {
                        sessionManager.clearSession()
                        navController.navigate(NavController.Publico.Inicio.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
            }
        }

        composable(NavHostController.Admin.Mapa.route) {
            GuardedRoute(
                requiredRol    = "ADMIN",
                sessionManager = sessionManager,
                navController  = navController
            ) {
                MapaAdminScreen(onBack = { navController.popBackStack() })
            }
        }

        composable(NavController.Admin.Reportes.route) {
            GuardedRoute(
                requiredRol    = "ADMIN",
                sessionManager = sessionManager,
                navController  = navController
            ) {
                ReportesAdminScreen(onBack = { navController.popBackStack() })
            }
        }

        composable(NavController.Admin.EstadoRepo.route) {
            GuardedRoute(
                requiredRol    = "ADMIN",
                sessionManager = sessionManager,
                navController  = navController
            ) {
                EstadoRepoAdminScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}
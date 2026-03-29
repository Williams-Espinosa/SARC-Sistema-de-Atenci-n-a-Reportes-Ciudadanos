import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.williamsel.sarc.core.navigation.NavController
import com.williamsel.sarc.login.presentacion.screens.LoginScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    sessionManager: SessionManager = hiltViewModel<SessionViewModel>().sessionManager,
    startDestination: String
) {
    val startDestination = when {
        !sessionManager.isLoggedIn()          -> NavController.Publico.Inicio.route
        sessionManager.getRol() == "ADMIN"    -> NavController.Admin.Panel.route
        sessionManager.getRol() == "CIUDADANO"-> NavController.Ciudadano.Panel.route
        else                                  -> NavController.Publico.Inicio.route
    }

    NavHost(navController = navController, startDestination = startDestination) {

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
                }
            )
        }

        composable(NavController.Ciudadano.Panel.route) {
            GuardedRoute(requiredRol = "CIUDADANO", sessionManager = sessionManager, navController = navController) {
                PanelCiudadanoScreen(...)
            }
        }

        composable(NavController.Admin.Panel.route) {
            GuardedRoute(requiredRol = "ADMIN", sessionManager = sessionManager, navController = navController) {
                PanelAdminScreen(...)
            }
        }
    }
}
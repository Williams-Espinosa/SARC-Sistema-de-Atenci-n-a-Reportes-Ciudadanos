package com.williamsel.sarc.core.navigation

sealed class NavController(val route: String) {


    sealed class Publico(route: String) : NavController(route) {
        data object Inicio      : Publico("publico/inicio")
        data object Login       : Publico("publico/login")
        data object Registro    : Publico("publico/registro")
        data object Terminos    : Publico("publico/terminos")
        data object Privacidad  : Publico("publico/privacidad")
    }


    sealed class Ciudadano(route: String) : NavController(route) {
        data object Panel           : Ciudadano("ciudadano/panel")
        data object Mapa            : Ciudadano("ciudadano/mapa")
        data object CrearReporte    : Ciudadano("ciudadano/crear_reporte")
        data object MisReportes     : Ciudadano("ciudadano/mis_reportes")
    }


    sealed class Admin(route: String) : NavController(route) {
        data object Panel       : Admin("admin/panel")
        data object Mapa        : Admin("admin/mapa")
        data object Reportes    : Admin("admin/reportes")
        data object EstadoRepo  : Admin("admin/estado_reportes")
    }
}
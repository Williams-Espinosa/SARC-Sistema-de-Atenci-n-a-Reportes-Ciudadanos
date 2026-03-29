package com.sarc.politicasdeprivacidad.presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val SarcGreen      = Color(0xFF2E7D32)
private val SarcGreenLight = Color(0xFFF1F8F1)
private val SarcGreenIcon  = Color(0xFFE8F5E9)
private val TextDark       = Color(0xFF1A2E1A)
private val TextMid        = Color(0xFF4A5A4A)
private val TextLight      = Color(0xFF7A8A7A)
private val Background     = Color(0xFFF5F5F5)
private val CardBackground = Color(0xFFFFFFFF)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PolideprivaScreen(
    onBack: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Política de",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextDark
                        )
                        Text(
                            text = "Privacidad",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextDark
                        )
                        Text(
                            text = "Última actualización: 20 de marzo, 2026",
                            fontSize = 11.sp,
                            color = TextLight
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = TextDark
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CardBackground
                )
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CardBackground)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = TextMid,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Volver",
                        color = TextMid,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onBack,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SarcGreen
                    )
                ) {
                    Text(
                        text = "Entendido",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "© 2026 Municipio de Suchiapa, Chiapas. Todos los derechos reservados.",
                    fontSize = 10.sp,
                    color = TextLight,
                    textAlign = TextAlign.Center
                )
            }
        },
        containerColor = Background
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            WelcomeCard()

            SectionCard(number = "1.", title = "Información que Recopilamos") {
                SectionParagraph(
                    "Al usar SARC, recopilamos la siguiente información para brindar " +
                            "un servicio eficiente y seguro:"
                )
                Spacer(modifier = Modifier.height(8.dp))
                CheckItem("Datos de registro: nombre, correo electrónico y contraseña cifrada")
                CheckItem("Ubicación GPS al momento de crear un reporte")
                CheckItem("Fotografías adjuntas a los reportes ciudadanos")
                CheckItem("Descripción y categoría de las incidencias reportadas")
                CheckItem("Historial de reportes realizados desde tu cuenta")
            }

            SectionCard(number = "2.", title = "Uso de la Información") {
                SectionParagraph(
                    "La información recopilada es utilizada exclusivamente para:"
                )
                Spacer(modifier = Modifier.height(8.dp))
                CheckItem("Gestionar y dar seguimiento a los reportes ciudadanos")
                CheckItem("Permitir a las autoridades identificar y atender las incidencias")
                CheckItem("Enviarte notificaciones sobre el estado de tus reportes")
                CheckItem("Mejorar el funcionamiento y la experiencia de la aplicación")
                CheckItem("Generar estadísticas anónimas de incidencias urbanas")
            }

            SectionCard(number = "3.", title = "Compartición de Datos") {
                SectionParagraph(
                    "El Municipio de Suchiapa se compromete a:"
                )
                Spacer(modifier = Modifier.height(8.dp))
                CheckItem("No vender ni comercializar tu información personal a terceros")
                CheckItem("Compartir los reportes únicamente con las áreas municipales responsables")
                CheckItem("No divulgar tus datos de contacto sin tu consentimiento expreso")
                CheckItem("Utilizar proveedores de servicios con estándares de seguridad equivalentes")
            }

            SectionCard(number = "4.", title = "Almacenamiento y Seguridad") {
                SectionParagraph(
                    "Tu información es protegida mediante las siguientes medidas:"
                )
                Spacer(modifier = Modifier.height(8.dp))
                CheckItem("Cifrado de datos en tránsito mediante protocolo HTTPS")
                CheckItem("Almacenamiento seguro en servidores en la nube con acceso restringido")
                CheckItem("Contraseñas almacenadas con hash criptográfico irreversible")
                CheckItem("Acceso a datos personales limitado al personal autorizado")
                CheckItem("Monitoreo continuo para detectar accesos no autorizados")
            }

            SectionCard(number = "5.", title = "Tus Derechos (ARCO)") {
                SectionParagraph(
                    "Conforme a la Ley Federal de Protección de Datos Personales en " +
                            "Posesión de los Particulares, tienes derecho a:"
                )
                Spacer(modifier = Modifier.height(8.dp))
                CheckItem("Acceso: consultar los datos personales que tenemos de ti")
                CheckItem("Rectificación: corregir datos inexactos o incompletos")
                CheckItem("Cancelación: solicitar la eliminación de tus datos")
                CheckItem("Oposición: oponerte al uso de tus datos para fines específicos")
            }

            SectionCard(number = "6.", title = "Permisos de la Aplicación") {
                SectionParagraph(
                    "SARC solicita los siguientes permisos en tu dispositivo:"
                )
                Spacer(modifier = Modifier.height(8.dp))
                CheckItem("Cámara: para capturar fotografías de las incidencias a reportar")
                CheckItem("Ubicación: para registrar el lugar exacto de cada reporte")
                CheckItem("Almacenamiento: para guardar imágenes temporalmente antes de subirlas")
                CheckItem("Internet: para sincronizar reportes con el servidor municipal")
                Spacer(modifier = Modifier.height(8.dp))
                SectionParagraph(
                    "Puedes revocar estos permisos en cualquier momento desde la " +
                            "configuración de tu dispositivo."
                )
            }

            SectionCard(number = "7.", title = "Retención de Datos") {
                SectionParagraph(
                    "Conservamos tu información personal mientras tu cuenta esté activa " +
                            "o sea necesaria para prestar el servicio. Los reportes cerrados se " +
                            "conservan en forma anonimizada con fines estadísticos. " +
                            "Puedes solicitar la eliminación de tu cuenta y datos en cualquier " +
                            "momento escribiendo a contacto@municipiosuchiapa.gob.mx."
                )
            }

            SectionCard(number = "8.", title = "Cambios a esta Política") {
                SectionParagraph(
                    "El Municipio de Suchiapa se reserva el derecho de actualizar esta " +
                            "Política de Privacidad en cualquier momento. Los cambios serán " +
                            "notificados a través de la aplicación y la fecha de última " +
                            "actualización será revisada en la parte superior de esta pantalla."
                )
            }

            SectionCard(number = "9.", title = "Contacto") {
                SectionParagraph(
                    "Para ejercer tus derechos ARCO o para preguntas sobre esta " +
                            "Política de Privacidad, contáctanos a:"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "contacto@municipiosuchiapa.gob.mx",
                    fontSize = 13.sp,
                    color = SarcGreen,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
private fun WelcomeCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(SarcGreenIcon, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = SarcGreen,
                    modifier = Modifier.size(20.dp)
                )
            }
            Column {
                Text(
                    text = "Tu privacidad es nuestra prioridad",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Esta Política de Privacidad describe cómo el Sistema de " +
                            "Atención y Reporte Ciudadano (SARC) del Municipio de Suchiapa, " +
                            "Chiapas, recopila, usa y protege tu información personal. " +
                            "Por favor, léela cuidadosamente antes de utilizar nuestro servicio.",
                    fontSize = 13.sp,
                    color = TextMid,
                    lineHeight = 19.sp
                )
            }
        }
    }
}

@Composable
private fun SectionCard(
    number: String,
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "$number $title",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )
            Spacer(modifier = Modifier.height(10.dp))
            content()
        }
    }
}

@Composable
private fun SectionParagraph(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        color = TextMid,
        lineHeight = 19.sp
    )
}

@Composable
private fun CheckItem(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(SarcGreenIcon, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = SarcGreen,
                modifier = Modifier.size(12.dp)
            )
        }
        Text(
            text = text,
            fontSize = 13.sp,
            color = TextMid,
            lineHeight = 19.sp,
            modifier = Modifier.weight(1f)
        )
    }
}


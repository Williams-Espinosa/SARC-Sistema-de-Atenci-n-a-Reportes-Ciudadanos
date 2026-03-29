import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs = context.getSharedPreferences("sarc_session", Context.MODE_PRIVATE)

    fun saveSession(token: String, rol: String) {
        prefs.edit()
            .putString("jwt", token)
            .putString("rol", rol)
            .apply()
    }

    fun getToken(): String? = prefs.getString("jwt", null)
    fun getRol(): String?   = prefs.getString("rol", null)
    fun isLoggedIn(): Boolean = getToken() != null

    fun clearSession() = prefs.edit().clear().apply()
}
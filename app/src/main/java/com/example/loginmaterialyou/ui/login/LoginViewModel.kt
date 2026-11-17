package com.example.loginmaterialyou.ui.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/** Estado inmutable de la pantalla de Login (patrón MVVM + flujo de datos unidireccional). */
data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val rememberMe: Boolean = false,
    val emailError: ErrorType? = null,
    val passwordError: ErrorType? = null,
    val isLoading: Boolean = false,
    val loginSuccess: Boolean = false
)

enum class ErrorType { EMPTY, INVALID, TOO_SHORT }

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChange(value: String) =
        _uiState.update { it.copy(email = value, emailError = null) }

    fun onPasswordChange(value: String) =
        _uiState.update { it.copy(password = value, passwordError = null) }

    fun onTogglePasswordVisibility() =
        _uiState.update { it.copy(passwordVisible = !it.passwordVisible) }

    fun onRememberMeChange(value: Boolean) =
        _uiState.update { it.copy(rememberMe = value) }

    fun onLoginClick() {
        val state = _uiState.value
        val emailError = when {
            state.email.isBlank() -> ErrorType.EMPTY
            !Patterns.EMAIL_ADDRESS.matcher(state.email).matches() -> ErrorType.INVALID
            else -> null
        }
        val passwordError = when {
            state.password.isEmpty() -> ErrorType.EMPTY
            state.password.length < 6 -> ErrorType.TOO_SHORT
            else -> null
        }

        if (emailError != null || passwordError != null) {
            _uiState.update { it.copy(emailError = emailError, passwordError = passwordError) }
            return
        }

        // Simulación de autenticación (prototipo, sin backend)
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            delay(1500)
            _uiState.update { it.copy(isLoading = false, loginSuccess = true) }
        }
    }

    fun onLogout() = _uiState.update { LoginUiState() }
}

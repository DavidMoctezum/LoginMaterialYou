package com.example.loginmaterialyou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginmaterialyou.ui.login.LoginScreen
import com.example.loginmaterialyou.ui.login.LoginViewModel
import com.example.loginmaterialyou.ui.theme.LoginMaterialYouTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginMaterialYouTheme {
                val viewModel: LoginViewModel = viewModel()
                val state by viewModel.uiState.collectAsStateWithLifecycle()

                if (state.loginSuccess) {
                    HomePlaceholder(onLogout = viewModel::onLogout)
                } else {
                    LoginScreen(
                        state = state,
                        onEmailChange = viewModel::onEmailChange,
                        onPasswordChange = viewModel::onPasswordChange,
                        onTogglePasswordVisibility = viewModel::onTogglePasswordVisibility,
                        onRememberMeChange = viewModel::onRememberMeChange,
                        onLoginClick = viewModel::onLoginClick
                    )
                }
            }
        }
    }
}

/** Pantalla mínima que confirma el login exitoso (el prototipo no incluye más pantallas). */
@androidx.compose.runtime.Composable
private fun HomePlaceholder(onLogout: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = stringResource(R.string.login_success),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 26.sp),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(24.dp))
            FilledTonalButton(onClick = onLogout) {
                Text(stringResource(R.string.logout))
            }
        }
    }
}

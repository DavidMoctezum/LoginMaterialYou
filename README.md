# Login Material You

Práctica de Interfaces Móviles: pantalla de Login para Android con **Material 3** y **Material You** (dynamic color), construida con Kotlin y Jetpack Compose.

- **Alumno:** _[tu nombre]_
- **Grupo:** _[tu grupo]_
- **Fecha de entrega:** 17 de noviembre de 2026

## Características

- Material 3 en todos los componentes (`OutlinedTextField`, `Button`, `OutlinedButton`, `Checkbox`, `TextButton`).
- Material You: en Android 12+ (API 31) los colores salen del fondo de pantalla; en versiones anteriores se usa una paleta de respaldo.
- Tema claro y oscuro según el sistema.
- Validación de correo (formato) y contraseña (mínimo 6 caracteres) con mensajes de error junto a cada campo.
- Mostrar y ocultar contraseña, estado de carga en el botón y pantalla de éxito.
- Arquitectura MVVM con flujo de datos unidireccional (`LoginViewModel` + `LoginUiState`).

## Requisitos

- Android Studio Ladybug (2024.2) o más reciente
- JDK 17 (incluido en Android Studio)
- Emulador o dispositivo con Android 8.0 (API 26) o superior; Android 12+ para ver Material You

## Cómo ejecutarlo

1. Clona el repositorio: `git clone <URL-de-tu-repositorio>`
2. En Android Studio: **File > Open** y selecciona la carpeta del proyecto.
3. Espera la sincronización de Gradle.
4. Ejecuta con **Run > Run 'app'**.

Para probar el login, usa cualquier correo con formato válido y una contraseña de 6 o más caracteres; la autenticación es simulada.

## Estructura

```
app/src/main/java/com/example/loginmaterialyou/
├── MainActivity.kt
└── ui/
    ├── login/
    │   ├── LoginScreen.kt
    │   └── LoginViewModel.kt
    └── theme/
        ├── Color.kt
        ├── Theme.kt
        └── Type.kt
docs/    bocetos, wireframes y mockups (PNG)
```

## Diseño

| Etapa | Archivo |
| --- | --- |
| Bocetos | `docs/01_bocetos_login.png` |
| Wireframes | `docs/02_wireframes_login.png` |
| Mockups | `docs/03_mockups_login.png`, `docs/04_mockups_material_you.png`, `docs/05_mockup_exito.png` |

La documentación completa (investigación, arquitectura y capturas) se entrega por separado.

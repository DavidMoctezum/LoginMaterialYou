# Guía de entrega (vence el 17 de noviembre)

## 1. Abrir y probar en Android Studio
1. File > Open > carpeta `LoginMaterialYou`.
2. Espera la sincronización de Gradle. Si pide actualizar el plugin de Android o Kotlin, acepta.
3. Crea un emulador con API 34 (Pixel 7) y ejecuta la app.
4. Toma las capturas (icono de cámara del emulador): inicial, errores, cargando, éxito, tema oscuro y otro fondo de pantalla.

## 2. Subir a GitHub (repositorio público)
Crea en github.com un repositorio **público** vacío (sin README) llamado `LoginMaterialYou` y, dentro de la carpeta del proyecto:

```bash
git init
git add .
git commit -m "Práctica Login Material 3 y Material You"
git branch -M main
git remote add origin https://github.com/<tu-usuario>/LoginMaterialYou.git
git push -u origin main
```

Sube después las capturas del emulador a `docs/capturas/` en un segundo commit:

```bash
git add docs/capturas
git commit -m "Agrega capturas de la implementación"
git push
```

## 3. Registrar en el Google Sheets
Ubica **la sección de tu grupo** (hay dos) y anota tu fila con:

| Campo | Qué poner |
| --- | --- |
| Nombre | Tu nombre completo |
| Repositorio | Enlace al repo público |
| Qué subí | Proyecto Android (Compose + M3), carpeta `docs` con bocetos, wireframes y mockups, README |
| Commits | Número y fecha de tus commits |
| Documentación | Enlace o nombre del archivo entregado |

## 4. Entregar la documentación
Exporta el documento a Word o PDF, pega tus capturas en la sección 6 y completa nombre, grupo y enlace del repositorio en la portada.

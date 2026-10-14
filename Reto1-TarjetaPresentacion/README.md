# Reto 1 · Tarjeta de Presentación Profesional

**Módulo:** 0489 · Programación Multimedia y Dispositivos Móviles
**Autor:** Marcelo González
**Tecnología:** Kotlin + Jetpack Compose (Android nativo)
**RA vinculado:** RA1 · Tecnologías de desarrollo para dispositivos móviles

## 📱 Qué es esta app

Una tarjeta de presentación digital (versión simplificada de un Linktree) que muestra una foto de perfil, un nombre, un rol profesional y un botón que enlaza directamente al perfil de GitHub del autor.

![Captura de la app](<img width="311" height="682" alt="image" src="https://github.com/user-attachments/assets/538de151-bad5-4535-aa91-29111cfd893e" />
)

## 🎯 Objetivo del reto

Partir de un proyecto Android base y modificarlo para construir una aplicación funcional propia, aplicando los conceptos vistos en clase: estructura de un proyecto Kotlin, componentes visuales de Jetpack Compose, gestión de recursos (imágenes e icono) y control de versiones con Git.

## 🛠️ Componentes y conceptos utilizados

| Componente / concepto | Para qué se usa en esta app |
|---|---|
| `Column` | Organiza los elementos en vertical (foto, nombre, rol, botón) |
| `Image` + `clip(CircleShape)` | Muestra la foto de perfil recortada en círculo |
| `Text` | Nombre y rol profesional |
| `Spacer` | Separación entre elementos |
| `Button` + `Intent` | Al pulsar, abre el navegador en el perfil de GitHub |
| `res/drawable` | Carpeta donde vive la imagen de perfil |
| `res/mipmap` (Image Asset Studio) | Icono personalizado de la app, sustituyendo al robot de Android por defecto |
| `strings.xml` (`app_name`) | Nombre visible de la app bajo el icono, en el móvil |

### Fragmento clave: el botón que abre GitHub

```kotlin
val context = LocalContext.current

Button(onClick = {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/joscanoav"))
    context.startActivity(intent)
}) {
    Text("Ver mi GitHub")
}
```

## 🚀 Cómo ejecutar el proyecto

1. Clonar o abrir el proyecto en Android Studio.
2. Esperar a que sincronice Gradle.
3. Ejecutar (▶) sobre un emulador o un dispositivo Android real con la depuración USB activada.

## 🧠 Qué he aprendido

- **Estructura del proyecto:** entendí dónde vive cada cosa: el código en `MainActivity.kt`, las imágenes en `res/drawable`, los iconos en `res/mipmap-*` y los textos en `res/values/strings.xml`.
- **Composición de pantallas:** en Compose la interfaz se construye anidando funciones (`Column` con `Image`, `Text`, `Spacer` y `Button` dentro), y el aspecto se controla con el `Modifier`.
- **Imágenes:** para mostrar la foto en círculo hay que aplicar `clip(CircleShape)` en el `Modifier` de la `Image`, y la imagen debe estar en `res/drawable` con un nombre en minúsculas y sin espacios.
- **Icono de la app:** con Image Asset Studio se configuran por separado la capa de fondo y la de primer plano, y el sistema genera los tamaños para cada densidad de pantalla.
- **Nombre de la app:** el nombre que se ve bajo el icono se cambia en `strings.xml` (`app_name`) sin tocar el nombre del proyecto.
- **Intents:** un `Intent` con `ACTION_VIEW` y una `Uri` permite delegar en otra aplicación (el navegador) desde un botón.
- **Git:** usé commits para ir guardando el avance del reto y poder volver atrás si algo fallaba.

## 🐞 Dificultades y cómo las resolví

- **Imports sin resolver:** al pegar código, Android Studio marcaba en rojo `Column`, `Image`, etc. Lo resolví usando Alt+Enter sobre cada palabra para que el IDE añadiera el import correspondiente.
- **Imagen que no cargaba:** el recurso no aparecía porque el nombre del archivo tenía mayúsculas o espacios. Lo renombré en minúsculas con guiones bajos y volví a sincronizar.
- **Icono que no cambiaba:** en el emulador seguía viéndose el robot por defecto. Desinstalé la app del emulador y la volví a ejecutar para que se aplicara el nuevo icono.
- **Botón sin abrir el enlace:** al principio no tenía acceso al contexto. Lo resolví obteniéndolo con `LocalContext.current` dentro del composable.

## 📂 Estructura del proyecto

```
app/src/main/java/.../MainActivity.kt   → pantalla principal (Compose)
app/src/main/res/drawable/              → imagen de perfil
app/src/main/res/mipmap-*/              → icono de la app
app/src/main/res/values/strings.xml     → nombre visible de la app
```

## 🔗 Enlace

- GitHub: [github.com/joscanoav](https://github.com/joscanoav)

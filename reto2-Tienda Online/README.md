# Reto 2 · E-Commerce Adaptativo (Responsive UI)

**Módulo:** 0489 · Programación Multimedia y Dispositivos Móviles  
**Autor:** Marcelo González  
**Tecnología:** Kotlin + Jetpack Compose (Android nativo)  
**RA vinculado:** RA1 y RA2 · Interfaces adaptables y limitaciones del dispositivo

## 📱 Producto Final (Capturas)

A continuación, se deben añadir dos capturas de pantalla de la aplicación funcionando en distintos dispositivos para demostrar que la interfaz se adapta al espacio disponible.

**Móvil en vertical:**
src="https://github.com/user-attachments/assets/2d52cac1-b141-4b2a-8807-9b6b3c8568aa"

**Tablet o móvil en horizontal:**

src="https://github.com/user-attachments/assets/9f7cb33b-1048-4253-a00b-3b7323a32ac0" 


### Esquema de referencia

La cuadrícula mantiene las mismas tarjetas y adapta el número de columnas según el espacio disponible.

![Esquema responsive: móvil en vertical (2 columnas) y tablet en horizontal (4 columnas)](<<img width="532" height="797" alt="image" src="https://github.com/user-attachments/assets/9f2716e0-aae7-48c6-9b93-600b6a7fd910" />

)

## 🎯 Objetivo del reto

El objetivo es comprender cómo se adaptan las interfaces de Android a diferentes tamaños y orientaciones de pantalla. Para ello, se utiliza una cuadrícula responsive con Jetpack Compose que aprovecha el espacio disponible y mejora la visualización de los productos.

## 🛠️ Componentes y conceptos utilizados

| Componente / Concepto | Para qué se usa en esta app |
| :--- | :--- |
| **LazyVerticalGrid** | Permite mostrar los productos en una cuadrícula desplazable. |
| **GridCells.Adaptive** | Calcula automáticamente cuántas columnas caben según el ancho disponible. |
| **Card** | Agrupa la imagen y los datos de cada producto en una tarjeta con bordes redondeados. |
| **ContentScale.Crop** | Recorta las imágenes para llenar el espacio sin deformarlas. |
| **maxLines y TextOverflow** | Limita el texto a una línea y añade puntos suspensivos si es demasiado largo. |
| **Mock Data** | Simula los productos mediante una clase de datos y una lista local. |

## 🧐 Reflexión y Pensamiento Crítico

**1. Sobre la adaptabilidad: ¿Por qué hemos usado `GridCells.Adaptive(minSize = ...)` en lugar de fijar el número de columnas con `GridCells.Fixed(2)`? ¿Qué ventaja tiene en el mundo real?**

Hemos usado `GridCells.Adaptive` porque permite que la aplicación calcule cuántas columnas caben según el tamaño de la pantalla. Así funciona mejor en móviles, tablets y diferentes orientaciones sin tener que cambiar manualmente el diseño.

**2. Sobre el diseño UI: ¿Qué ocurría con las tarjetas si el nombre de un producto era muy largo y ocupaba dos líneas mientras los demás ocupaban una? ¿Cómo lo hemos solucionado?**

Los nombres largos podían hacer que las tarjetas tuvieran una apariencia desigual. Lo hemos solucionado limitando el texto a una línea con `maxLines = 1` y usando `TextOverflow.Ellipsis` para mostrar puntos suspensivos.

**3. Sobre las imágenes: ¿Por qué es importante usar `ContentScale.Crop` en la imagen del producto cuando cambiamos el ancho de la tarjeta al rotar la pantalla?**

Porque la imagen se adapta al espacio de la tarjeta sin deformarse. Si cambia el tamaño de la tarjeta, se recortan los bordes que sobran y se mantiene una presentación uniforme.

**4. Visión de futuro: Ahora mismo nuestros productos están escritos directamente en el código (hardcodeados). ¿Qué crees que necesitaría nuestra app en el futuro para que esta tienda mostrara productos reales de internet?**

Necesitaría conectarse a una API o a un servidor para obtener los productos reales. También tendría que gestionar las imágenes, los posibles errores de conexión y la carga de los datos.

## 🚀 Cómo ejecutar el proyecto

1. Clonar el repositorio y abrirlo en Android Studio.
2. Ejecutar la aplicación en un emulador de móvil, por ejemplo, un Pixel.
3. Girar el móvil a horizontal o utilizar un emulador de tablet.
4. Comprobar que la cuadrícula adapta el número de columnas al espacio disponible.
5. Realizar las capturas de pantalla y guardarlas en `img/capturas/`.

## 🐞 Dificultades y cómo las resolví

Una de las principales dificultades fue conseguir que la interfaz se adaptara correctamente a diferentes tamaños de pantalla. Lo resolví utilizando `LazyVerticalGrid` con `GridCells.Adaptive`, que ajusta automáticamente el número de columnas.

También tuve que controlar los nombres largos de los productos para evitar que las tarjetas quedaran desiguales. Para solucionarlo, limité el texto a una línea y añadí puntos suspensivos.

Por último, utilicé `ContentScale.Crop` para mantener las imágenes proporcionadas y conseguir que todas las tarjetas tuvieran una apariencia más uniforme.


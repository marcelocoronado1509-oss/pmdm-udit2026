package com.example.burguershop

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.TransferableContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(Modifier.fillMaxSize()) {
                    PantallaPrincipal()
                }
            }
        }
    }
}

data class Producto(
    val nombre: String,
    val precio: String,
    val imanResId: Int
)

val catalogoHamburguesas = listOf(
    Producto(
        "Clasica con queso", "6,5 ",
        R.drawable.burger_clasica
    ),
    Producto(
        "BBQ BACON", "7,5 ",
        R.drawable.burger_bbq
    ),
    Producto(
        "Doble carnes", "8,5 ",
        R.drawable.burger_doble
    ),
    Producto(
        "Vegetariana", "7,2 ",
        R.drawable.burger_vegetariana
    ),
    Producto(
        "Picante Jalapeño", "7,8 ",
        R.drawable.burger_picante
    ),
    Producto(
        "Pollo crispy", "6,9 ",
        R.drawable.burger_pollo
    ),
)

@Composable
fun CatalogoHamburguesas(productos: List<Producto>) {
    /*LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    )  */
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 250.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        items(productos) { producto ->
            TarjetaProducto(producto)
        }

    }
}

@Composable
fun TarjetaProducto(producto: Producto) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(
                    id = producto.imanResId
                ),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = producto.nombre,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = producto.precio,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("añadir al carrito")
                }
            }

        }
    }
}

@Composable
fun PantallaPrincipal(){
    var mostrarPortada by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        delay(1500)
        mostrarPortada = false
    }
    if (mostrarPortada){
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        Text("🍔 Burger shop", fontSize = 32.sp, fontWeight = FontWeight.Bold)

    }
    }else{
        CatalogoHamburguesas(productos = catalogoHamburguesas)
    }
}
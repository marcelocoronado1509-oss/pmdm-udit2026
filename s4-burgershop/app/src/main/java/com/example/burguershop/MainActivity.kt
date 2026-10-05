package com.example.burguershop

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MaterialTheme {
                Surface(Modifier.fillMaxSize()) {

                }
            }
        }
    }
}

data class Producto(
    val nombre : String,
    val precio : String,
    val imanResId : Int
)
val catalogoHamburguesas = listOf (
    Producto( "Clasica con queso", "6,5 ",
    R.drawable.burger_clasica
),
    Producto("BBQ BACON", "7,5 ",
        R.drawable.burger_bbq),
    Producto("Doble carnes", "8,5 ",
        R.drawable.burger_doble),
            Producto("Vegetariana", "7,2 ",
    R.drawable.burger_vegetariana),
    Producto("Picante Jalapeño", "7,8 ",
        R.drawable.burger_picante),
    Producto("Pollo crispy", "6,9 ",
        R.drawable.burger_pollo)

)



package com.example.relaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.relaciones.Database.AppDatabase // Asegúrate de tener esta clase configurada
import com.example.relaciones.Repository.PersonaRepository
import com.example.relaciones.Repository.CocheRepository // Añadir si necesitas gestionar coches
import com.example.relaciones.Screen.UserApp

class MainActivity : ComponentActivity() {

    private lateinit var personaRepository: PersonaRepository
    private lateinit var cocheRepository: CocheRepository // Añadir si necesitas gestionar coches

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos la base de datos
        val db = AppDatabase.getDatabase(applicationContext)

        // Inicializamos el repositorio de Persona
        personaRepository = PersonaRepository(db.personaDao())

        // Inicializamos el repositorio de Coche (opcional)
        cocheRepository = CocheRepository(db.cocheDao())

        // Habilitamos Edge-to-Edge (opcional)
        enableEdgeToEdge()

        // Establecemos el contenido con Jetpack Compose
        setContent {
            UserApp(personaRepository, cocheRepository) // Pasamos ambos repositorios
        }
    }
}

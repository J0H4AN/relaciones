package com.example.relaciones.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.relaciones.Model.Persona
import com.example.relaciones.Model.Coche
import com.example.relaciones.Repository.PersonaRepository
import com.example.relaciones.Repository.CocheRepository // Asegúrate de importar el CocheRepository
import kotlinx.coroutines.launch

@Composable
fun UserApp(personaRepository: PersonaRepository, cocheRepository: CocheRepository) { // Agregar cocheRepository como parámetro

    // Variables de estado para manejar los datos de Persona y Coche
    var nombre by remember { mutableStateOf("") }
    var apellido1 by remember { mutableStateOf("") }
    var apellido2 by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }

    var matricula by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var caballos by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Inputs para los datos de Persona
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = apellido1,
            onValueChange = { apellido1 = it },
            label = { Text("Apellido 1") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = apellido2,
            onValueChange = { apellido2 = it },
            label = { Text("Apellido 2") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = dni,
            onValueChange = { dni = it },
            label = { Text("DNI") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Inputs para los datos de Coche
        OutlinedTextField(
            value = matricula,
            onValueChange = { matricula = it },
            label = { Text("Matrícula") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = modelo,
            onValueChange = { modelo = it },
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = caballos,
            onValueChange = { caballos = it },
            label = { Text("Caballos") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para guardar la Persona y el Coche
        Button(onClick = {
            coroutineScope.launch {
                // Crear una nueva Persona
                val nuevaPersona = Persona(
                    nombre = nombre,
                    apellido1 = apellido1,
                    apellido2 = apellido2,
                    dni = dni
                )

                // Insertar Persona en la base de datos
                personaRepository.insertar(nuevaPersona)

                // Obtener la última persona insertada (con su ID)
                val personas = personaRepository.getAllPersonas()
                val personaInsertada = personas.last()

                // Crear un coche asociado a la persona
                val nuevoCoche = Coche(
                    matricula = matricula,
                    marca = marca,
                    modelo = modelo,
                    caballos = caballos.toInt(),
                    persona_id = personaInsertada.id // Asegúrate de que persona_id coincida con el nombre de la columna en la tabla
                )

                // Guardar el coche en la base de datos
                cocheRepository.insertar(nuevoCoche) // Aquí se inserta el coche

                // Confirmación (puedes mostrar en pantalla o debug)
                println("Persona y coche creados con éxito")
            }
        }) {
            Text("Crear Persona y Coche")
        }
    }
}

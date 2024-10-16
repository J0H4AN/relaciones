package com.example.relaciones.Repository

import com.example.relaciones.DAO.PersonaDao
import com.example.relaciones.Model.Persona

class PersonaRepository(private val personaDao: PersonaDao) {
    suspend fun insertar(persona: Persona) {
        personaDao.insert(persona)
    }

    suspend fun getAllPersonas(): List<Persona> {
        return personaDao.getAllPersonas()
    }

    suspend fun eliminar(persona: Persona) {
        personaDao.deletePersona(persona)
    }

    suspend fun actualizar(persona: Persona) {
        personaDao.updatePersona(persona)
    }

    suspend fun deletePersonaById(personaId: Int) {
        personaDao.deletePersonaById(personaId)
    }
}

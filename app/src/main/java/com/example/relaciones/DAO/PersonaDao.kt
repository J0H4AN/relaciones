package com.example.relaciones.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import com.example.relaciones.Model.Persona

@Dao
interface PersonaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(persona: Persona)

    @Query("SELECT * FROM personas")
    suspend fun getAllPersonas(): List<Persona>

    @Delete
    suspend fun deletePersona(persona: Persona)

    @Update
    suspend fun updatePersona(persona: Persona)

    @Query("DELETE FROM personas WHERE id = :personaId")
    suspend fun deletePersonaById(personaId: Int)
}

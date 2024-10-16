package com.example.relaciones.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


import androidx.room.*
import com.example.relaciones.Model.Coche

@Dao
interface CocheDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(coche: Coche)

    @Query("SELECT * FROM coches WHERE persona_id = :personaId")
    suspend fun getCochesByPersonaId(personaId: Int): List<Coche>

    @Delete
    suspend fun deleteCoche(coche: Coche)

    @Update
    suspend fun updateCoche(coche: Coche)

    @Query("DELETE FROM coches WHERE matricula = :matricula")
    suspend fun deleteCocheByMatricula(matricula: String)
}

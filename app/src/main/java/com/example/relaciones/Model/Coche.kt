package com.example.relaciones.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "coches",
    foreignKeys = [ForeignKey(
        entity = Persona::class,
        parentColumns = ["id"],
        childColumns = ["persona_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Coche(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val matricula: String,
    val marca: String,
    val modelo: String,
    val caballos: Int,
    val persona_id: Long = 0 // Clave foránea que referencia a Persona
)

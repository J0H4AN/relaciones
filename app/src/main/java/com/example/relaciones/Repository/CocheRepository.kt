package com.example.relaciones.Repository

import com.example.relaciones.DAO.CocheDao
import com.example.relaciones.Model.Coche

class CocheRepository(private val cocheDao: CocheDao) {
    suspend fun insertar(coche: Coche) {
        cocheDao.insert(coche)
    }

    suspend fun getCochesByPersonaId(personaId: Int): List<Coche> {
        return cocheDao.getCochesByPersonaId(personaId)
    }

    suspend fun eliminar(coche: Coche) {
        cocheDao.deleteCoche(coche)
    }

    suspend fun actualizar(coche: Coche) {
        cocheDao.updateCoche(coche)
    }

    suspend fun deleteCocheByMatricula(matricula: String) {
        cocheDao.deleteCocheByMatricula(matricula)
    }
}

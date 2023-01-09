package com.example.nourah_alhindi_retake1.models

import androidx.lifecycle.LiveData

class Repository(val universitiesDao: UniversitiesDao) {

    val getUniversities: LiveData<List<UniversityTable>> =universitiesDao.getUniversities()

    suspend fun addUniversity(name: UniversityTable)
    {
       universitiesDao.addUniversity(name)
    }

    suspend fun deleteUniversity(name: UniversityTable){
       universitiesDao.deleteUniversity(name)
    }


    suspend fun updateUniversity(name: UniversityTable)
    {
        universitiesDao.updateUniversity(name)
    }

}
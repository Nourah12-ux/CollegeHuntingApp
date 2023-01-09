package com.example.nourah_alhindi_retake1.models

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UniversitiesDao {

    @Query("SELECT * FROM UniversityTable ORDER BY pk ASC")
    fun getUniversities():LiveData<List<UniversityTable>>

    @Insert
    suspend fun addUniversity(University:UniversityTable)

    @Delete
    suspend fun deleteUniversity(University: UniversityTable)

    @Update
    suspend fun updateUniversity(University: UniversityTable)
}
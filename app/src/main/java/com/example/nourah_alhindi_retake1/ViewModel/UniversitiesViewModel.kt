package com.example.nourah_alhindi_retake1.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.nourah_alhindi_retake1.models.Repository
import com.example.nourah_alhindi_retake1.models.UniversitiesDao
import com.example.nourah_alhindi_retake1.models.UniversitiesDatabase
import com.example.nourah_alhindi_retake1.models.UniversityTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UniversitiesViewModel(application: Application):AndroidViewModel(application) {

    private val repository:Repository
    private val Universities: LiveData<List<UniversityTable>>
    private val universitiesDao:UniversitiesDao

    init {
        universitiesDao=UniversitiesDatabase.getDatabase(application).universitiesDao()
        repository=Repository(universitiesDao)
        Universities=repository.getUniversities
    }
     fun addUniversity(name: UniversityTable) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addUniversity(name)
        }
    }

    fun getUniversities(): LiveData<List<UniversityTable>> {
        return Universities
    }


    fun deleteUniversity(name: UniversityTable) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteUniversity(name)
        }
    }


    fun update(name: UniversityTable) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.updateUniversity(name)
        }

    }

}
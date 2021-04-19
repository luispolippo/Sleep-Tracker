package com.polippo.sleeptracker.sleepquality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.polippo.sleeptracker.database.SleepDatabaseDao
import java.lang.IllegalArgumentException

class SleepQualityViewModelFactory(
        private val sleepNightKey: Long,
        private val datasource: SleepDatabaseDao) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SleepQualityViewModel::class.java)){
            return SleepQualityViewModel(sleepNightKey, datasource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}


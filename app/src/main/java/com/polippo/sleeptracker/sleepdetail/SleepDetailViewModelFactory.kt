package com.polippo.sleeptracker.sleepdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.polippo.sleeptracker.database.SleepDatabaseDao
import java.lang.IllegalArgumentException
import javax.sql.DataSource

class SleepDetailViewModelFactory(
        private val sleepNightKey: Long,
        private val dataSource: SleepDatabaseDao): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SleepDetailViewModel::class.java)){
            return SleepDetailViewModel(sleepNightKey, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
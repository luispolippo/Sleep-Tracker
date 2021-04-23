package com.polippo.sleeptracker.sleepdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polippo.sleeptracker.database.SleepDatabaseDao
import com.polippo.sleeptracker.database.SleepNight

class SleepDetailViewModel(
        private val sleepNightKey: Long = 0L,
        dataSource: SleepDatabaseDao): ViewModel() {


    val database = dataSource

    private val night = MediatorLiveData<SleepNight>()

    fun getNight() = night

    init{
        night.addSource(database.getNightWithId(sleepNightKey), night::setValue)
    }

    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()
    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker

    fun doneNavigation(){
        _navigateToSleepTracker.value = null
    }

    fun onClose(){
        _navigateToSleepTracker.value = true
    }


        }
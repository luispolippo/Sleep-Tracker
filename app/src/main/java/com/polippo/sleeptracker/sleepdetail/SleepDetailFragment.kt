package com.polippo.sleeptracker.sleepdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.polippo.sleeptracker.R
import com.polippo.sleeptracker.database.SleepDatabase
import com.polippo.sleeptracker.databinding.FragmentSleepDetailBinding
import com.polippo.sleeptracker.sleeptracker.SleepNightAdapter

class SleepDetailFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentSleepDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sleep_detail, container, false)

        val application = requireNotNull(this.activity).application

        val arguments = SleepDetailFragmentArgs.fromBundle(arguments!!)

        val datasource = SleepDatabase.getInstance(application).sleepDatabaseDao
        val viewModelFactory = SleepDetailViewModelFactory(arguments.sleepNightKey, datasource)

        val sleepDetailViewModel = ViewModelProvider(this, viewModelFactory).get(SleepDetailViewModel::class.java)

        binding.sleepDetailViewModel = sleepDetailViewModel

        binding.lifecycleOwner = this

        sleepDetailViewModel.navigateToSleepTracker.observe(viewLifecycleOwner, Observer {
            if(it == true){
                this.findNavController().navigate(SleepDetailFragmentDirections.actionSleepDetailFragmentToSleepTrackerFragment())

                sleepDetailViewModel.doneNavigation()
            }
        })

        return binding.root

    }

}
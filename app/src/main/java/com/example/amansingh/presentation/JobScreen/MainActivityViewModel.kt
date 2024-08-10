package com.example.amansingh.presentation.JobScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amansingh.api.JobRepository
import com.example.amansingh.data.api.model.JobList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor (
    private val jobRepository: JobRepository
): ViewModel(){

    private val _jobList = MutableStateFlow<JobList?>(null)
    val jobList: StateFlow<JobList?> = _jobList

    public var currentPage = 1
    public var isLastPage = false
    public var isLoading = false

    init {
        loadJobs(currentPage)
    }

     fun loadJobs(page: Int) {
        if (isLoading || isLastPage) return
        viewModelScope.launch {
            isLoading = true
            val newPage = jobRepository.getJobListArray(page)
            isLoading = false;
//            _jobList.value = jobRepository.getJobListArray()
            newPage?.let {
                if (it.results.isEmpty()) {
                    isLastPage = true
                } else {
                    val oldJobs = _jobList.value?.results ?: emptyList()
                    _jobList.value = JobList(oldJobs + it.results)
                    currentPage++
                }
            }

        }
    }



}
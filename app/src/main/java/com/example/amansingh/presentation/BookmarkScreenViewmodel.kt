package com.example.amansingh.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amansingh.data.room.JobDaoImpl
import com.example.amansingh.data.room.JobEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject





@HiltViewModel
class BookmarkScreenViewmodel @Inject constructor(
    private val jobDao:JobDaoImpl
): ViewModel() {




    private val _bookmarkedJobs = jobDao.getAllBookmarks().stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )
    val bookmarkedJobs: StateFlow<List<JobEntity>> = _bookmarkedJobs


    fun addBookmark(jobEntity: JobEntity) {
        viewModelScope.launch {
            jobDao.insertBookmark(jobEntity)
        }
    }

    fun removeBookmark(jobEntity: JobEntity) {
        viewModelScope.launch {
            jobDao.deleteBookmark(jobEntity)
        }
    }
}
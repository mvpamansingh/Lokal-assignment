package com.example.amansingh.presentation.DetailScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.amansingh.data.api.model.Results


//class DetailScreenViewModel():ViewModel() {
//
//
//    var job: Results? by mutableStateOf(null)
//        private set
//
//    fun setJob(job: Results) {
//        this.job = job
//    }
//
//    fun clearJob() {
//        this.job = null
//    }
//}
class DetailScreenViewModel : ViewModel() {
    var job = mutableStateOf<Results?>(null)
        private set  // This makes the setter private, while the getter remains public.

    fun setJob(newJob: Results) {
        job.value = newJob
    }

    fun clearJob() {
        job.value = null
    }
}
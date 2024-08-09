package com.example.amansingh.api

import com.example.amansingh.data.api.model.JobList
import okhttp3.Response
import javax.inject.Inject

class JobRepository @Inject constructor(
    private val jobService: JobListAPI
) {
    suspend fun getJobListArray(page: Int): JobList? {
        val response = jobService.getJobList(page.toString())
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}
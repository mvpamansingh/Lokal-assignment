package com.example.amansingh.api

import com.example.amansingh.data.api.model.JobList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JobListAPI {

    @GET("common/jobs")
    suspend fun getJobList(@Query("page") page: String): Response<JobList>
}
package com.example.amansingh.data.room

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class JobDaoImpl @Inject constructor(
    private val dao:JobDao
) {

    fun getAllBookmarks(): Flow<List<JobEntity>>
    {



        return dao.getAllBookmarkedJobs()
    }

    suspend fun insertBookmark(jobEntity: JobEntity)
    {
        dao.bookmarkJob(jobEntity = jobEntity)
    }

    suspend fun deleteBookmark(jobEntity: JobEntity)
    {
        dao.removeBookmark(jobEntity=jobEntity)
    }

}
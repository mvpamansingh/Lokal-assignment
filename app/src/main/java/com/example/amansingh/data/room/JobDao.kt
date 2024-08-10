package com.example.amansingh.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JobDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bookmarkJob(jobEntity: JobEntity)

    @Query("SELECT * FROM bookmarked_jobs")
    fun getAllBookmarkedJobs(): Flow<List<JobEntity>>

    @Delete
    suspend fun removeBookmark(jobEntity: JobEntity)
}
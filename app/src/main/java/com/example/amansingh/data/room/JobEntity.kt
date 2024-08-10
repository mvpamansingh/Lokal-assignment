package com.example.amansingh.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bookmarked_jobs")
data class JobEntity(


    @PrimaryKey val id: String,

    val jobRole: String,

    val location: String,

    val salaryMin: Int,

    val salaryMax: Int,

    val contactNumber: String
)

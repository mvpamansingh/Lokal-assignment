package com.example.amansingh.data.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [JobEntity::class], version=1)
abstract class AppDatabaseClass: RoomDatabase() {

    abstract fun jobDao():JobDao
}
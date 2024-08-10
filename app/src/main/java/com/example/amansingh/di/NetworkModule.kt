package com.example.amansingh.di

import android.content.Context
import androidx.room.Room
import com.example.amansingh.api.JobListAPI
import com.example.amansingh.data.room.AppDatabaseClass
import com.example.amansingh.data.room.JobDao
import com.example.amansingh.data.room.JobDaoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://testapi.getlokalapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideJobListAPI(retrofit: Retrofit): JobListAPI {
        return retrofit.create(JobListAPI::class.java)
    }






    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabaseClass
    {
        return Room.databaseBuilder(
            appContext,
            AppDatabaseClass::class.java,
            "AppDatabaseClass"
        ).build()
    }


    @Provides
    @Singleton
    fun provideNoteDao(appDatabaseClass: AppDatabaseClass):JobDao
    {
        return appDatabaseClass.jobDao()
    }




    @Provides
    @Singleton
    fun notesDaoIml(jobDao: JobDao):JobDaoImpl
    {
        return     JobDaoImpl(jobDao)
    }
}
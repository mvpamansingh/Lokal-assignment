package com.example.amansingh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amansingh.api.JobListAPI
import com.example.amansingh.presentation.JobScreen.MainActivityViewModel
import com.example.amansingh.presentation.MainScreen
import com.example.amansingh.ui.theme.AmanSinghTheme
import dagger.hilt.android.AndroidEntryPoint

import javax.inject.Inject

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var jobListAPI: JobListAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Log.d("API-RESPONSE", "before launch")
//        GlobalScope.launch {
//            Log.d("API-RESPONSE", "inside launch")
//            var response = jobListAPI.getJobList()
//            Log.d("API-RESPONSE", "after response")
//            Log.d("API-RESPONSE", response.body().toString())
//        }
        enableEdgeToEdge()
        setContent {
            val viewModel: MainActivityViewModel = viewModel()
//            JobListScreen(viewModel)
            AmanSinghTheme {


                MainScreen()
            }
        }
    }
}



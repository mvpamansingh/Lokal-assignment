package com.example.amansingh

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amansingh.api.JobListAPI
import com.example.amansingh.data.api.model.Results
import com.example.amansingh.presentation.JobScreen
import com.example.amansingh.presentation.MainScreen
import com.example.amansingh.presentation.TopBar
import com.example.amansingh.ui.theme.AmanSinghTheme
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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



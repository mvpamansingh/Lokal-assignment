package com.example.amansingh.presentation

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.amansingh.MainActivityViewModel
import com.example.amansingh.data.api.model.Results
//import com.example.amansingh.ui.theme.Blur
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze


@Composable
fun JobScreen(
    modifier: Modifier = Modifier,
    hazeState: HazeState,
    paddingValues: PaddingValues,
    viewModel: MainActivityViewModel,
    detailScreenViewModel: DetailScreenViewModel,
    navController:NavHostController
) {

    val jobs = viewModel.jobList.collectAsState().value?.results ?: emptyList()


    Box(modifier = modifier.background(MaterialTheme.colorScheme.background)) {


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .haze(state = hazeState),
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(), bottom = 70.dp
            )
        ) {
            items(jobs) { job ->
                JobItemTest1(modifier = Modifier, job = job ,        onInfoClicked = {
                    detailScreenViewModel.setJob(job)
                    navController.navigate(Screens.DetailsScreen.screen)
                } )
            }

            item{
                if(!viewModel.isLastPage){
                    Text("Loading more...", modifier = Modifier.padding(8.dp))
                    LaunchedEffect(key1 = "loadMore") {
                        viewModel.loadJobs(viewModel.currentPage)
                    }
                } else {
                    Text("You've reached the end of the list.", modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun JobCard(job: Results) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Title: ${job.title}", style = MaterialTheme.typography.titleLarge)
        Text("Role: ${job.job_role}", style = MaterialTheme.typography.bodyMedium)
        // Add more fields as needed...
    }
}



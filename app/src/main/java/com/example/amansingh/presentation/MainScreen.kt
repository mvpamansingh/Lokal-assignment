package com.example.amansingh.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.amansingh.MainActivityViewModel
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Work)
    }
    val hazeState = remember {
        HazeState()
    }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
//                        .background(MaterialTheme.colorScheme.background),

        containerColor = Color.Transparent,

        topBar = {
            TopBar(
                modifier = Modifier
                    .hazeChild(state = hazeState)
                    .padding(0.dp),
                scrollBehavior = scrollBehavior,

                )

        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color.Transparent,
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Work
                        navigationController.navigate(Screens.JobScreen.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Work,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = if (selected.value == Icons.Default.Work) Color.Green else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Bookmarks
                        navigationController.navigate(Screens.BookmarksScreen.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Bookmarks,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = if (selected.value == Icons.Default.Bookmarks) Color.Green else Color.DarkGray
                    )
                }
            }
        }

    ) { innerPadding ->
        val viewModel: MainActivityViewModel = viewModel()
        val viewModelDetails: DetailScreenViewModel = viewModel()
        val bookmarkScreenViewmodel:BookmarkScreenViewmodel = viewModel()
        NavHost(
            navController = navigationController,
            startDestination = Screens.JobScreen.screen,
            modifier = Modifier.padding(0.dp)
        ) {
            composable(Screens.JobScreen.screen) {

                JobScreen(
                    modifier = Modifier.padding(innerPadding),
                    hazeState = hazeState,
                    paddingValues = innerPadding,
                    viewModel = viewModel,
                    navController = navigationController,
                    detailScreenViewModel = viewModelDetails,
                    bookmarkScreenViewmodel =bookmarkScreenViewmodel
                )
            }
            composable(Screens.BookmarksScreen.screen) {
                BookmarksScreen(bookmarkScreenViewmodel = bookmarkScreenViewmodel)
            }

            composable("jobDetails") {

//                val job = viewModelDetails.job
//                if (job != null) {
//                    JobDetailsScreen(job)
//                } else {
//                    // Handle null case, perhaps navigate back or show an error
//                }
                DetailsScreen(detailScreenViewModel = viewModelDetails)
            }
        }
    }
}
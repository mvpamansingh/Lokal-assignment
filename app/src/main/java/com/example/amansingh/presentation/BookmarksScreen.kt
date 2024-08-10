package com.example.amansingh.presentation

import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.haze

@Composable
fun BookmarksScreen(bookmarkScreenViewmodel: BookmarkScreenViewmodel) {

    val bookmarkedjobs by bookmarkScreenViewmodel.bookmarkedJobs.collectAsState()

    if(bookmarkedjobs.isEmpty())
    {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.Center) {
            Text("Bookmarks will be shown here", fontWeight = FontWeight.SemiBold)
        }
    }
    else
    {
        LazyColumn {
            items(bookmarkedjobs) { job ->
                // Display each bookmarked job
                Text(text = "Job Role: ${job.jobRole}")
                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "Job location: ${job.location}")
                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "Job Id: ${job.id}")
                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "Job Contact number: ${job.contactNumber}")
                Spacer(modifier = Modifier.height(4.dp))


                Text(text = "Job Salary range: ${job.salaryMin} -${job.salaryMax}")
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }

}
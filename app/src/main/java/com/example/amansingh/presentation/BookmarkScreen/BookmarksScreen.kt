package com.example.amansingh.presentation.BookmarkScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.amansingh.R

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



        LazyColumn(
            modifier = Modifier.padding(top =90.dp, bottom = 120.dp)
                .fillMaxSize()
                .background(colorResource(id = R.color.fetch_background))


            ) {
            items(bookmarkedjobs) { job ->



                    BooKMarkScreenElement(job = job, bookmarkScreenViewmodel =bookmarkScreenViewmodel )


            }


        }
    }

}
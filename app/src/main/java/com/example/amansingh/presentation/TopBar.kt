package com.example.amansingh.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent
        ),
        title = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalArrangement = Arrangement.Center
            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(60.dp)
//                        .border(
//                            width = 1.dp,
//                            color = Color.White,
//                            shape = RoundedCornerShape(30.dp) // Reduced for a more subtle effect
//                        )
//                        .padding(horizontal = 16.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        imageVector = Icons.Rounded.Search,
//                        contentDescription = "Search",
//                        tint = Color.White,
//                        modifier = Modifier.size(28.dp)
//                    )
//
//                    Spacer(modifier = Modifier.width(16.dp))
//
//                    Text(
//                        text = "Trending new jobs",
//                        fontSize = 18.sp,
//                        color = Color.White,
//                        modifier = Modifier.weight(1f)
//                    )
//
//                    Icon(
//                        imageVector = Icons.Rounded.Mic,
//                        contentDescription = "Voice search",
//                        tint = Color.White,
//                        modifier = Modifier.size(28.dp)
//                    )
//                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Search Jobs",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp) // Added padding to align with the row above
                )


            }
        }
    )
}
package com.example.amansingh.presentation.JobScreen

import androidx.compose.material3.Card

import androidx.compose.ui.unit.dp
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.amansingh.R
import com.example.amansingh.data.api.model.Results
import com.example.amansingh.data.room.JobEntity
import com.example.amansingh.presentation.BookmarkScreen.BookmarkScreenViewmodel


@Composable
fun MyCard(
    modifier:Modifier= Modifier,
    job: Results,
    onInfoClicked: () -> Unit,
    bookmarkScreenViewmodel: BookmarkScreenViewmodel
) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.card)),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Row for Location and Bookmark Icon
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Location Card
                Card(
                    shape = RoundedCornerShape(50),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.fetch_background)),
                    modifier = Modifier.padding(end = 2.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 7.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            tint = Color.Black,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${job.job_location_slug}",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }
                // Bookmark Icon
                IconButton(
                    onClick = {
                        val bookmark = JobEntity(
                            jobRole = job.job_role,
                            location = job.job_location_slug,
                            salaryMin = job.salary_min,
                            salaryMax = job.salary_max,
                            contactNumber = job.whatsapp_no,
                            id = job.id.toString()
                        )
                        Toast.makeText(context, "Bookmark Added",Toast.LENGTH_SHORT).show()
                        bookmarkScreenViewmodel.addBookmark(bookmark)
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = "Bookmark",
                        tint = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(11.dp))
            // Row for Job Title and Job Icon
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Work,
                    contentDescription = "Job Title",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "${job.job_role}", fontSize = 18.sp, fontWeight =FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.CurrencyRupee,
                    contentDescription = "Job Title",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
                Text(text = ": ${job.salary_min} - ${job.salary_max}", fontSize = 16.sp)

            }
            Spacer(modifier = Modifier.height(16.dp))
            // Row for Mobile Number and Call Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Mobile Number",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "${job.whatsapp_no}")
                }

                Button(
                    onClick = { onInfoClicked() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.fetch_background)),
                    border = BorderStroke(2.dp, Color.LightGray),

                ) {
                    Text(text = "Read More")
                }
            }
        }
    }
}


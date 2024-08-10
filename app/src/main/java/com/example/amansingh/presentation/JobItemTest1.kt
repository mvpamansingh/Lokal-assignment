package com.example.amansingh.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amansingh.data.api.model.Results


@Composable
fun JobItemTest1(modifier:Modifier= Modifier,
            job: Results , onInfoClicked: () -> Unit)
{
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF2193b0),
            Color(0xFF6dd5ed)
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(CornerSize(10.dp))
            ),

        shape = RoundedCornerShape(12.dp),

        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            // Row for Job Title and Job Location
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Filled.ManageAccounts,
                    contentDescription = "Job Role",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "${job.job_role}",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Location",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "${job.job_location_slug}",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "₹: ${job.salary_min} - ${job.salary_max}",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Row for Job Salary and Phone Number
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Contact Number",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${job.whatsapp_no}",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.Bookmark,
                    contentDescription = "Bookmark",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                //space between the two icons
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Info",
                    modifier = Modifier.size(24.dp).clickable { onInfoClicked() },
                    tint = MaterialTheme.colorScheme.secondary
                )

            }
        }
    }
}
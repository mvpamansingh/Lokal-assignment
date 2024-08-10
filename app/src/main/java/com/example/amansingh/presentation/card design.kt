package com.example.amansingh.presentation

import androidx.compose.material3.Card

import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.amansingh.R

//@Composable
//fun MyCard() {
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = Color.Yellow
//        ),
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()
//            .wrapContentHeight()
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//        ) {
//            Text(text = "Location", fontSize = 20.sp, fontWeight = FontWeight.Bold)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = "Job Title", fontSize = 18.sp)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = "Salary", fontSize = 18.sp)
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(
//                onClick = { /* Handle Read More click */ },
//                modifier = Modifier.align(Alignment.End)
//            ) {
//                Text(text = "Read More")
//            }
//        }
//    }
//}


//@Composable
//fun MyCard() {
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        colors =CardDefaults.cardColors(Color(0xFFACB4BB)),
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()
//            .wrapContentHeight()
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//        ) {
//            // Row for Location and Bookmark Icon
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                // Location Card
//                Card(
//                    shape = RoundedCornerShape(50),
//                    colors =CardDefaults.cardColors(Color(0xFF90CAF9)),
//                    modifier = Modifier.padding(end = 2.dp)
//                ) {
//                    Text(
//                        text = "Location",
//                        fontSize = 15.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 7.dp)
//                    )
//                }
//                // Bookmark Icon
//                IconButton(
//                    onClick = { /* Handle bookmark click */ },
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Bookmark,
//                        contentDescription = "Bookmark",
//                        tint = Color.Black
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(11.dp))
//            Text(text = "Job Title", fontSize = 18.sp)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = "Salary", fontSize = 18.sp)
//            Spacer(modifier = Modifier.height(16.dp))
//            Row(modifier =Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween )
//            {
//                Text(text = "mobile number")
//
//                Button(
//                    onClick = { /* Handle Read More click */ },
//
//                    border = BorderStroke(2.dp, Color.Red)
//                ) {
//                    Text(text = "Read More")
//                }
//            }
//
//
//
//        }
//    }
//}

@Composable
fun MyCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color(0xFFACB4BB)),
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
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.card)),
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
                            text = "Location",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }
                // Bookmark Icon
                IconButton(
                    onClick = { /* Handle bookmark click */ },
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
                Text(text = "Job Title", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Salary", fontSize = 18.sp)
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
                    Text(text = "Mobile Number")
                }

                Button(
                    onClick = { /* Handle Read More click */ },
                    border = BorderStroke(2.dp, Color.Red),

                ) {
                    Text(text = "Read More")
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCard()
}
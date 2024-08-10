package com.example.amansingh.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DetailsScreen(detailScreenViewModel: DetailScreenViewModel)
{

    //var job by detailScreenViewModel.job
    val job = detailScreenViewModel.job.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

            Text(
                text = "Text ${job?.company_name}",
                modifier = Modifier.padding(vertical = 8.dp)
            )

        Text(
            text = "Text ${job?.fee_details}",
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = "Text ${job?.other_details}",
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = "Text ${job?.company_name}",
            modifier = Modifier.padding(vertical = 8.dp)
        )


    }
}
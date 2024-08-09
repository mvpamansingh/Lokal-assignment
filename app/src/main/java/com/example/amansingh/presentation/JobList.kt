package com.example.amansingh.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun JobList(
    modifier: Modifier= Modifier,
    paddingValues: PaddingValues
)
{


    LazyColumn(modifier=modifier,
        contentPadding = PaddingValues(
            top= paddingValues.calculateTopPadding(), bottom = 70.dp
        ))
    {
        items(7) { index ->
//            JobItem(modifier = modifier)
        }


    }
}
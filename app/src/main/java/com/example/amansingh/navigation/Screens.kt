package com.example.amansingh.navigation

sealed class Screens (val screen: String){
    data object JobScreen: Screens("jobs")
    data object BookmarksScreen: Screens("bookmarks")
    data object DetailsScreen : Screens("jobDetails")
}
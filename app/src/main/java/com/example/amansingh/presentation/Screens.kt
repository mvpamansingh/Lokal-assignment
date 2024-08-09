package com.example.amansingh.presentation

sealed class Screens (val screen: String){
    data object JobScreen: Screens("jobs")
    data object BookmarksScreen: Screens("bookmarks")
}
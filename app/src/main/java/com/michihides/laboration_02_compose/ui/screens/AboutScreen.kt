package com.michihides.laboration_02_compose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.michihides.laboration_02_compose.destinations.HomeDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AboutScreen(navigator: DestinationsNavigator) {
    Column {
        Text(text = "About")

        Button(onClick = {
            navigator.navigate(HomeDestination)
        }) {
            Text(text = "Back to Home")
        }
    }
}
package com.michihides.laboration_02_compose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.michihides.laboration_02_compose.destinations.HomeDestination
import com.michihides.laboration_02_compose.ui.theme.Beige
import com.michihides.laboration_02_compose.ui.theme.BeigeDark
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AboutScreen(navigator: DestinationsNavigator) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Beige)
    ) {
        Text(text = "About")

        Button(onClick = {
            navigator.navigate(HomeDestination)
        },
            colors = ButtonDefaults.buttonColors(BeigeDark)
            ) {
            Text(text = "Back to Home")
        }
    }
}
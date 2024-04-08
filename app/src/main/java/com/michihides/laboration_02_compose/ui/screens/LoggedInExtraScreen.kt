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
import com.michihides.laboration_02_compose.destinations.LoggedInScreenDestination
import com.michihides.laboration_02_compose.ui.models.User
import com.michihides.laboration_02_compose.ui.theme.Beige
import com.michihides.laboration_02_compose.ui.theme.BeigeDark
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LoggedInExtraScreen(
    username: String,
    password: String,
    navigator: DestinationsNavigator
) {
    val user = User(username, password)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Beige)
    ) {
        Text(text = "Extra Cool Info")

        Button(onClick = {
            navigator.navigate(
                LoggedInScreenDestination(
                    username = user.username,
                    password = user.password
                )
            )
        },
            colors = ButtonDefaults.buttonColors(BeigeDark)
            ) {
            Text(text = "Back")
        }
    }
}
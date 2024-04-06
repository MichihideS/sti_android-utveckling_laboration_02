package com.michihides.laboration_02_compose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.michihides.laboration_02_compose.destinations.HomeDestination
import com.michihides.laboration_02_compose.destinations.LoggedInExtraScreenDestination
import com.michihides.laboration_02_compose.ui.models.User
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LoggedInScreen(
    username: String,
    password: String,
    navigator: DestinationsNavigator
) {
    val user = User(username, password)

    Column {
        Text(text = "Logged In")
        Text(text = "Welcome ${user.username}")
        
        Button(onClick = {
            navigator.navigate(LoggedInExtraScreenDestination(
                username = user.username,
                password = user.password
            ))
        }) {
            Text(text = "Cool Info")
        }

        Button(onClick = {
            navigator.navigate(HomeDestination)
        }) {
            Text(text = "Logout to Home")
        }
    }
}
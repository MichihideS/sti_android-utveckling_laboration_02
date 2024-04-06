package com.michihides.laboration_02_compose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.michihides.laboration_02_compose.destinations.HomeDestination
import com.michihides.laboration_02_compose.destinations.LoggedInScreenDestination
import com.michihides.laboration_02_compose.ui.composables.LoginHandler
import com.michihides.laboration_02_compose.ui.models.User
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignInScreen(navigator: DestinationsNavigator) {
    Column {
        Text(text = "Sign In Page")

        var user by remember { mutableStateOf(
            User("", "")
        ) }

        val userList by remember { mutableStateOf(listOf(
            User("Michan", "123"),
            User("Test", "222"),
            User("Kristoffer", "1337")
        ))
        }

        var isUserExistent by remember { mutableStateOf(true) }

        LoginHandler(
            user = user,
            onChangeUser = { user = it }
        )

        

        Button(onClick = {
            navigator.navigate(LoggedInScreenDestination)
        }) {
            Text(text = "Log In")
        }

        Button(onClick = {
            navigator.navigate(HomeDestination)
        }) {
            Text(text = "Back to Home")
        }
    }
}
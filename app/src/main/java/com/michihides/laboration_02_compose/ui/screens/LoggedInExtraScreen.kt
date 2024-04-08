package com.michihides.laboration_02_compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.michihides.laboration_02_compose.R
import com.michihides.laboration_02_compose.destinations.LoggedInScreenDestination
import com.michihides.laboration_02_compose.ui.composables.ButtonColumn
import com.michihides.laboration_02_compose.ui.composables.GeneralButton
import com.michihides.laboration_02_compose.ui.composables.TextColumn
import com.michihides.laboration_02_compose.ui.models.User
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

    // Main text on the LoggedInExtraScreen
    TextColumn(text = stringResource(id = R.string.logged_in_cool_info_explained))

    ButtonColumn {
        /* Button that navigates to the LoggedInScreen and sends the username and password
        ** as params as you press the button
         */
        GeneralButton(textButton = stringResource(id = R.string.back)) {
            navigator.navigate(LoggedInScreenDestination(
                username = user.username,
                password = user.password
            ))
        }
    }
}
package com.michihides.laboration_02_compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.michihides.laboration_02_compose.R
import com.michihides.laboration_02_compose.destinations.HomeDestination
import com.michihides.laboration_02_compose.destinations.LoggedInExtraScreenDestination
import com.michihides.laboration_02_compose.ui.composables.BackgroundImage
import com.michihides.laboration_02_compose.ui.composables.ButtonColumn
import com.michihides.laboration_02_compose.ui.composables.DotaLogo
import com.michihides.laboration_02_compose.ui.composables.GeneralButton
import com.michihides.laboration_02_compose.ui.composables.TextColumn
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

    // Main Text on the LoggedInScreen
    TextColumn(
        text = "Welcome ${user.username}"
    )

    BackgroundImage()

    DotaLogo()

    ButtonColumn {
        /* Button that navigates to the LoggedInExtraScreen and sends the username and password
        ** as params as you press the button
        */
        GeneralButton(textButton = stringResource(id = R.string.logged_in_cool_info)) {
            navigator.navigate(LoggedInExtraScreenDestination(
                username = user.username,
                password = user.password
            ))
        }

        // Button that navigates you back to the Home screen (MainActivity)
        GeneralButton(textButton = stringResource(id = R.string.logged_in_back_home)) {
            navigator.navigate(HomeDestination)
        }
    }
}
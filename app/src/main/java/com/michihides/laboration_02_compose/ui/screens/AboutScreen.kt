package com.michihides.laboration_02_compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.michihides.laboration_02_compose.R
import com.michihides.laboration_02_compose.destinations.HomeDestination
import com.michihides.laboration_02_compose.ui.composables.BackgroundImage
import com.michihides.laboration_02_compose.ui.composables.ButtonColumn
import com.michihides.laboration_02_compose.ui.composables.GeneralButton
import com.michihides.laboration_02_compose.ui.composables.TextColumn
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AboutScreen(navigator: DestinationsNavigator) {
    // Main text on the AboutScreen
    TextColumn(text = stringResource(id = R.string.about_info))

    BackgroundImage()

    ButtonColumn {
        // Button that navigates to the Home screen (MainActivity)
        GeneralButton(textButton = stringResource(id = R.string.back_home)) {
            navigator.navigate(HomeDestination)
        }
    }
}
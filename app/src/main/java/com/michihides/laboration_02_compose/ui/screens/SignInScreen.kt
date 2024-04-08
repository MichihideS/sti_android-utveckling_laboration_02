package com.michihides.laboration_02_compose.ui.screens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.laboration_02_compose.R
import com.michihides.laboration_02_compose.destinations.HomeDestination
import com.michihides.laboration_02_compose.ui.composables.BackgroundImage
import com.michihides.laboration_02_compose.ui.composables.ButtonColumn
import com.michihides.laboration_02_compose.ui.composables.GeneralButton
import com.michihides.laboration_02_compose.ui.errorHandling.LoginErrorHandler
import com.michihides.laboration_02_compose.ui.composables.LoginHandler
import com.michihides.laboration_02_compose.ui.composables.TextColumn
import com.michihides.laboration_02_compose.ui.models.User
import com.michihides.laboration_02_compose.ui.theme.BeigeDark
import com.michihides.laboration_02_compose.ui.theme.WhiteDarker
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignInScreen(navigator: DestinationsNavigator) {
    // Main Text on the SignInScreen
    TextColumn(
        text = stringResource(id = R.string.sign_in_page)
    )

    BackgroundImage()

    ButtonColumn {
        val showArray = remember { mutableStateOf(false) }

        /* An Alertdialog that will show itself if set to true which happens when you press
        ** the List of Users button. Some Design on the Alertdialog itself as well
         */
        if(showArray.value) {
            AlertDialog(
                onDismissRequest = { showArray.value = false },
                title = { Text(text = stringResource(id = R.string.alert_dialog_title))},
                text = { Text(
                    text = stringResource(id = R.string.alert_dialog_users),
                    fontSize = 16.sp
                )},
                shape = RoundedCornerShape(5.dp),
                containerColor = WhiteDarker,
                confirmButton = {
                    Button(
                        onClick = {showArray.value = false},
                        colors = ButtonDefaults.buttonColors(BeigeDark),
                        shape = RoundedCornerShape(5.dp)
                        ) {
                        Text(text = stringResource(id = R.string.alert_dialog_confirm))
                    }
                }
            )
        }

        // The Button that enables the Alertdialog
        GeneralButton(textButton = stringResource(id = R.string.predefined_array)) {
                showArray.value = true
        }

        // Initializing the User Object
        var user by remember {
            mutableStateOf(
                User("", "")
            )
        }

        // Predefined list of Users that contains a username and a password
        val userList by remember {
            mutableStateOf(
                listOf(
                    User("Michan", "123"),
                    User("Test", "222"),
                    User("Kristoffer", "1337")
                )
            )
        }

        // Variable to check if the user exists
        var isUserExistent by remember { mutableStateOf(true) }

        // Calls the LoginHandler function which is the input fields for the user
        LoginHandler(
            user = user,
            onChangeUser = { user = it }
        )

        val showLoginError = remember { mutableStateOf(false) }

        /* An Alertdialog that will show itself if set to true which happens when you press
        ** the Log In Button with the wrong credentials. When you press OK the dialog will
        ** disappear and isUserExistent will be set to true again which sounds wrong but
        ** it worked so kept it for now
        */
        if(showLoginError.value) {
            AlertDialog(
                onDismissRequest = { showLoginError.value = false },
                title = { Text(text = stringResource(id = R.string.login_error_title))},
                text = { Text(
                    text = stringResource(id = R.string.login_error_text),
                    fontSize = 16.sp
                )},
                shape = RoundedCornerShape(5.dp),
                containerColor = WhiteDarker,
                confirmButton = {
                    Button(
                        onClick = {
                            showLoginError.value = false
                            isUserExistent = true},
                        colors = ButtonDefaults.buttonColors(BeigeDark),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Text(text = stringResource(id = R.string.login_error_confirm))
                    }
                }
            )
        }

        // If user doesn't exist get an alert dialog
        if (!isUserExistent)  {
            showLoginError.value = true
        }

        // Button that navigates you to the LoggedInScreen if the right credentials are typed in
        GeneralButton(textButton = stringResource(id = R.string.log_in)) {
            if (!LoginErrorHandler().userExist(user, userList, navigator)) {
                isUserExistent = false
            }

            LoginErrorHandler().userExist(user, userList, navigator)
        }

        // Button that navigates to the Home Screen (MainActivity)
        GeneralButton(textButton = stringResource(id = R.string.back_home)) {
            navigator.navigate(HomeDestination)
        }
    }
}
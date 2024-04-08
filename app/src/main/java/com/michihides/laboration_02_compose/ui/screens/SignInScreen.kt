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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.laboration_02_compose.R
import com.michihides.laboration_02_compose.destinations.HomeDestination
import com.michihides.laboration_02_compose.ui.composables.ButtonColumn
import com.michihides.laboration_02_compose.ui.composables.GeneralButton
import com.michihides.laboration_02_compose.ui.errorHandling.LoginErrorHandler
import com.michihides.laboration_02_compose.ui.composables.LoginHandler
import com.michihides.laboration_02_compose.ui.composables.TextColumn
import com.michihides.laboration_02_compose.ui.models.User
import com.michihides.laboration_02_compose.ui.theme.BeigeDark
import com.michihides.laboration_02_compose.ui.theme.BeigeTransparency
import com.michihides.laboration_02_compose.ui.theme.WhiteDarker
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignInScreen(navigator: DestinationsNavigator) {
    TextColumn(
        text = stringResource(id = R.string.sign_in_page)
    )

    ButtonColumn {
        val showArray = remember { mutableStateOf(false) }

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

        GeneralButton(textButton = stringResource(id = R.string.predefined_array)) {
                showArray.value = true
        }
        
        var user by remember {
            mutableStateOf(
                User("", "")
            )
        }

        val userList by remember {
            mutableStateOf(
                listOf(
                    User("Michan", "123"),
                    User("Test", "222"),
                    User("Kristoffer", "1337")
                )
            )
        }
        var isUserExistent by remember { mutableStateOf(true) }

        LoginHandler(
            user = user,
            onChangeUser = { user = it }
        )

        if (!isUserExistent) {
            Text(text = stringResource(id = R.string.error_login))
        }

        GeneralButton(textButton = stringResource(id = R.string.log_in)) {
            if (!LoginErrorHandler().userExist(user, userList, navigator)) {
                isUserExistent = false
            }

            LoginErrorHandler().userExist(user, userList, navigator)
        }

        GeneralButton(textButton = stringResource(id = R.string.back_home)) {
            navigator.navigate(HomeDestination)
        }
    }
}
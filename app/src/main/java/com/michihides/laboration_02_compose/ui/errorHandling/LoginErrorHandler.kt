package com.michihides.laboration_02_compose.ui.errorHandling

import com.michihides.laboration_02_compose.destinations.LoggedInScreenDestination
import com.michihides.laboration_02_compose.ui.models.User
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/* Checks if the user exists and if the password matches as well it will take you to the
** LoggedInScreen with the username and password as params
 */
class LoginErrorHandler {
    fun userExist(
        user: User,
        userList: List<User>,
        navigator: DestinationsNavigator
    ): Boolean {
        for (i in userList) {
            if(user.username == i.username && user.password == i.password) {
                navigator.navigate(
                    LoggedInScreenDestination(
                        username = user.username,
                        password = user.password
                    )
                )
            }
        }

        return false
    }
}
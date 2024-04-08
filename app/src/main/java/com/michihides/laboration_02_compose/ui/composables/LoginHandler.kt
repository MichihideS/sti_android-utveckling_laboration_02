package com.michihides.laboration_02_compose.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.michihides.laboration_02_compose.ui.models.User
import com.michihides.laboration_02_compose.ui.theme.WhiteDarker

/* Component for the username and password fields on the sign in page with different styling
** The password field being hidden when you type so your password won't be visible
*/
@Composable
fun LoginHandler(
    user: User,
    onChangeUser: (User) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        OutlinedTextField(
            value = user.username,
            onValueChange = { onChangeUser(user.copy(username = it))},
            label = { Text(text = "Username")},
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = WhiteDarker,
                unfocusedContainerColor = WhiteDarker,
                disabledContainerColor = WhiteDarker
            )
        )

        OutlinedTextField(
            value = user.password,
            onValueChange = { onChangeUser(user.copy(password = it))},
            label = { Text(text = "Password")},
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = WhiteDarker,
                unfocusedContainerColor = WhiteDarker,
                disabledContainerColor = WhiteDarker),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}
package com.michihides.laboration_02_compose.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.michihides.laboration_02_compose.ui.models.User

@Composable
fun LoginHandler(
    user: User,
    onChangeUser: (User) -> Unit
) {
    Column {
        OutlinedTextField(
            value = user.username,
            onValueChange = { onChangeUser(user.copy(username = it))},
            label = { Text(text = "Username")}
        )

        OutlinedTextField(
            value = user.password,
            onValueChange = { onChangeUser(user.copy(password = it))},
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}
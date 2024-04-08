package com.michihides.laboration_02_compose.ui.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.laboration_02_compose.ui.theme.BeigeDark

// A reusable Button that is used as main Button on all the screens with some design and styling
@Composable
fun GeneralButton(
    textButton: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(BeigeDark),
        modifier = Modifier
            .padding(12.dp)
            .width(250.dp)
            .height(50.dp),
        shape = RoundedCornerShape(5.dp)
    ){

        Text(
            text = textButton,
            fontSize = 22.sp
        )
    }
}
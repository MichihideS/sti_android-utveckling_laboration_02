package com.michihides.laboration_02_compose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.Text
import com.michihides.laboration_02_compose.ui.theme.Beige
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.laboration_02_compose.ui.theme.BeigeTransparency

@Composable
fun TextColumn(
    text: String
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Beige)
       ) {
        Text(text = text,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(70.dp)
                .padding(top = 80.dp)
                .border(2.dp, Color.Black)
                .background(BeigeTransparency)
                .padding(20.dp)
        )
    }
}
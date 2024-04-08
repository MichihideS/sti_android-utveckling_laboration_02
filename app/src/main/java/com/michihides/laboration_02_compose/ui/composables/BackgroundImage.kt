package com.michihides.laboration_02_compose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.michihides.laboration_02_compose.R

@Composable
fun BackgroundImage() {
        Image(
            painter = painterResource(id = R.drawable.dota_logo_background),
            contentDescription = stringResource(id = R.string.dota_logo_background),
            contentScale = ContentScale.Crop,
            alpha = 0.1F,
        )

}
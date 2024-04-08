package com.michihides.laboration_02_compose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.michihides.laboration_02_compose.R

@Composable
fun DotaLogo() {
    // Main Dota Logo picture
    Image(
        painter = painterResource(id = R.drawable.dota_logo),
        contentDescription = stringResource(id = R.string.dota_logo_main),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(80.dp)
    )
}
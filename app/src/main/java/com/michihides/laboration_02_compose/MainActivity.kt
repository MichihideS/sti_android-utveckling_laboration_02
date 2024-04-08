package com.michihides.laboration_02_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.michihides.laboration_02_compose.destinations.AboutScreenDestination
import com.michihides.laboration_02_compose.destinations.SignInScreenDestination
import com.michihides.laboration_02_compose.ui.composables.ButtonColumn
import com.michihides.laboration_02_compose.ui.composables.GeneralButton
import com.michihides.laboration_02_compose.ui.composables.TextColumn
import com.michihides.laboration_02_compose.ui.theme.Laboration_02_ComposeTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboration_02_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}

@RootNavGraph(start = true)
@Destination
@Composable
fun Home(navigator: DestinationsNavigator) {
    TextColumn(
        text = stringResource(id = R.string.welcome_text)
    )

    ButtonColumn {
        GeneralButton(textButton = stringResource(id = R.string.sign_in)) {
            navigator.navigate(SignInScreenDestination)
        }

        GeneralButton(textButton = stringResource(id = R.string.about)) {
            navigator.navigate(AboutScreenDestination)
        }
    }
}






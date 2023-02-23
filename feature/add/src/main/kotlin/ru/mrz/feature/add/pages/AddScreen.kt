package ru.mrz.feature.add.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.androidx.AndroidScreen
import ru.mrz.core.ui.theme.AppTextStyle
import ru.mrz.feature.add.R

class AddScreen : AndroidScreen() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(stringResource(R.string.title_add), style = AppTextStyle.screenTitle)
                    }
                )
            }
        ) { paddingValues ->

        }
    }
}

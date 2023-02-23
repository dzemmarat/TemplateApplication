package ru.mrz.template.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import ru.mrz.core.navigation.SharedScreen
import ru.mrz.core.ui.theme.AppIcons
import ru.mrz.template.R

object ProfileTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = AppIcons.Profile
            val title = stringResource(R.string.title_profile)
            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        SharedScreen.Profile.resolve()
    }
}

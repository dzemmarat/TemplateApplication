package ru.mrz.template.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import ru.mrz.core.navigation.SharedScreen
import ru.mrz.core.ui.theme.AppIcons
import ru.mrz.template.R

object AddTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = AppIcons.Add
            val title = stringResource(R.string.title_add)
            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        SharedScreen.Add.resolve()
    }
}

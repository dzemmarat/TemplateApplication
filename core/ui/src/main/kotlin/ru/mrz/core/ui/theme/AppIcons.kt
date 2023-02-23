package ru.mrz.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import ru.mrz.core.ui.R

object AppIcons {
    val Home: Painter
        @Composable get() = painterResource(id = R.drawable.ic_home)

    val Add: Painter
        @Composable get() = painterResource(id = R.drawable.ic_add)

    val Profile: Painter
        @Composable get() = painterResource(id = R.drawable.ic_person)
}
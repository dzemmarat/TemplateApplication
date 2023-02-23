package ru.mrz.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ru.mrz.core.ui.theme.AppTextStyle
import ru.mrz.core.ui.theme.TemplateApplicationTheme
import ru.mrz.template.tabs.AddTab
import ru.mrz.template.tabs.HomeTab
import ru.mrz.template.tabs.ProfileTab

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
//        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            TemplateApplicationTheme {
                TabNavigator(HomeTab) {
                    BottomSheetNavigator {
                        Scaffold(
                            modifier = Modifier
                                .fillMaxSize()
                                .navigationBarsPadding()
                                .statusBarsPadding(),
                            bottomBar = {
                                BottomNavigation()
                            }
                        ) { padding ->
                            Box(modifier = Modifier.padding(padding)) {
                                CurrentTab()
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun BottomNavigation() {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background
        ) {
            TabNavigationItem(HomeTab)
            TabNavigationItem(AddTab)
            TabNavigationItem(ProfileTab)
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(
        tab: Tab,
    ) {
        val tabNavigator = LocalTabNavigator.current
        BottomNavigationItem(
            selected = tabNavigator.current.key == tab.key,
            onClick = { tabNavigator.current = tab },
            icon = {
                Icon(
                    painter = tab.options.icon!!,
                    contentDescription = tab.options.title
                )
            },
            label = {
                Text(
                    text = tab.options.title,
                    style = AppTextStyle.menuLabel
                )
            },
            selectedContentColor = MaterialTheme.colors.primary,
            unselectedContentColor = MaterialTheme.colors.secondary
        )
    }
}


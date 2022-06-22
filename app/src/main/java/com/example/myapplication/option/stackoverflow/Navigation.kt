package com.example.myapplication.option.stackoverflow

import com.example.myapplication.NavigationItem
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.fragments.ContainerFragment

@Composable
fun Navigation(
    navController: NavHostController,
    fragmentManager: FragmentManager,
    getCommitFunction: (
        fragment: Fragment,
        tag: String
    ) -> (FragmentTransaction.(containerId: Int) -> Unit)
) {

    NavHost(navController, startDestination = NavigationItem.Home.route) {
        enumValues<NavigationItem>().forEach { item ->
            composable(item.route) {
                FragmentContainer(
                    modifier = Modifier.fillMaxSize(),
                    fragmentManager = fragmentManager,
                    commit = getCommitFunction(
                        ContainerFragment.newInstance(item.title, item.color),
                        item.route
                    )
                )
            }
        }
    }
}

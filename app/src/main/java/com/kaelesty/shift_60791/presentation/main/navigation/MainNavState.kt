package com.kaelesty.shift_60791.presentation.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class MainNavState(
	val navHostController: NavHostController
) {

	fun navigateTo(route: String) {
		navHostController.navigate(route) {
			launchSingleTop = true
			popUpTo(navHostController.graph.startDestinationId) {
				saveState = true
			}
			restoreState = true
		}
	}
}

@Composable
fun rememberMainNavState(
	navHostController: NavHostController = rememberNavController()
): MainNavState {
	 return remember {
		 MainNavState(navHostController)
	 }
}
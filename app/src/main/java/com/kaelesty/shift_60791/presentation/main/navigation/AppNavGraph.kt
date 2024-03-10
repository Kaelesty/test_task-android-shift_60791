package com.kaelesty.shift_60791.presentation.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
	navHostController: NavHostController,
	startDestination: String,
	usersListContent: @Composable () -> Unit,
	userDetailsContent: @Composable () -> Unit,
) {
	NavHost(
		navController = navHostController,
		startDestination = startDestination
	) {

		composable(AppScreen.UserDetails.route) {
			userDetailsContent()
		}

		composable(AppScreen.UsersList.route) {
			usersListContent()
		}
	}
}
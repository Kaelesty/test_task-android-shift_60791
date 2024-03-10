package com.kaelesty.shift_60791.presentation.main.navigation

sealed class AppScreen(
	val route: String
) {

	companion object {
		private const val ROUTE_USERSLIST = "users_list"
		private const val ROUTE_USERDETAILS = "user_details"
	}

	object UsersList: AppScreen(ROUTE_USERSLIST)
	object UserDetails: AppScreen(ROUTE_USERDETAILS)
}
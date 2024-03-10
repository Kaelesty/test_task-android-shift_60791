package com.kaelesty.shift_60791.presentation.main

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kaelesty.shift_60791.domain.entities.User
import com.kaelesty.shift_60791.presentation.ViewModelFactory
import com.kaelesty.shift_60791.presentation.main.navigation.AppNavGraph
import com.kaelesty.shift_60791.presentation.main.navigation.AppScreen
import com.kaelesty.shift_60791.presentation.main.navigation.rememberMainNavState
import com.kaelesty.shift_60791.presentation.theme.SHIFT60791Theme
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainScreen(
	viewModelFactory: ViewModelFactory
) {

	val viewModel: MainViewModel = viewModel(factory = viewModelFactory)

	val navigationState = rememberMainNavState()

	AppNavGraph(
		navHostController = navigationState.navHostController,
		startDestination = AppScreen.UsersList.route,
		usersListContent = {
			UsersList(
				usersFlow = viewModel.usersFlow,
				loadUsers = { viewModel.loadUsers() },
				updateUsers = { viewModel.loadUsers(true) },
				onUserCardClick = {
					viewModel.setUserToShowDetails(it)
					navigationState.navigateTo(AppScreen.UserDetails.route)
				}
			)
		},
		userDetailsContent = {
			UserDetails(
				userFlow = viewModel.userFlow
			)
		},
	)
}
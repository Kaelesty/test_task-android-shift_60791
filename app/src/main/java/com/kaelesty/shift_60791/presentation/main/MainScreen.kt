package com.kaelesty.shift_60791.presentation.main

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kaelesty.shift_60791.domain.entities.User
import com.kaelesty.shift_60791.presentation.ViewModelFactory
import com.kaelesty.shift_60791.presentation.theme.SHIFT60791Theme

@Composable
fun MainScreen(
	viewModelFactory: ViewModelFactory
) {

	val viewModel: MainViewModel = viewModel(factory = viewModelFactory)

	val users = viewModel.users.observeAsState(listOf())

	if (users.value.isEmpty()) {
		viewModel.reloadUsers()
	}
	else {
		UsersList(users = users.value)
	}
}

@Composable
fun UsersList(
	users: List<User>
) {
	users.forEach {
		Log.d("MainScreen.kt", it.toString())
	}
	LazyColumn {
		items(users) { user ->
			UserCard(user = user)
		}
	}
}

@Preview
@Composable
fun PreviewUsersListEmpty() {
	SHIFT60791Theme {
		UsersList(users = listOf())
	}
}
package com.kaelesty.shift_60791.presentation.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaelesty.shift_60791.domain.entities.User
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UsersList(
	usersFlow: StateFlow<List<User>>,
	loadUsers: () -> Unit,
	updateUsers: () -> Unit,
	onUserCardClick: (User) -> Unit,
) {

	val users by usersFlow.collectAsState()

	if (users.isEmpty()) {
		loadUsers()
	}

	LazyColumn {
		stickyHeader {
			Card(
				modifier = Modifier
					.padding(8.dp)
					.fillMaxWidth()
			) {
				Row(
					Modifier.padding(8.dp),
					verticalAlignment = Alignment.CenterVertically
				) {
					UserCardText(text = "Test Task shift_60791", isTitle = true)
					Spacer(Modifier.weight(1f))
					IconButton(onClick = { updateUsers() }) {
						Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
					}
				}
			}
		}
		items(users) { user ->
			UserCard(
				user = user,
				onClick = {
					onUserCardClick(it)
				}
			)
		}
	}
}
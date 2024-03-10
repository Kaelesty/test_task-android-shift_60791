package com.kaelesty.shift_60791.presentation.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kaelesty.shift_60791.domain.entities.User
import kotlinx.coroutines.flow.StateFlow

@Composable
fun UserDetails(
	userFlow: StateFlow<User>,
) {

	val user by userFlow.collectAsState()
	
	Column(
		modifier = Modifier
			.verticalScroll(remember {
				ScrollState(0)
			})
	) {
		InfoCard(title = null) {
			AsyncImage(
				model = user.picture, 
				contentDescription = "Human photo",
				modifier = Modifier
					.fillMaxWidth()
					.size(400.dp)
			)
		}
		InfoCard(title = "${user.nameTitle}${if (user.nameTitle.length < 4) "." else ""} ${user.nameFirst} ${user.nameLast}") {
			UserCardText(text = "Gender: ${user.gender}")
			UserCardText(text = "Age:  ${user.age}")
			UserCardText(text = "Birthday:  ${user.birthday}")

		}
		InfoCard(title = "Contacts") {
			UserCardText(text = "Phone:  ${user.phone}")
			UserCardText(text = "Cell:  ${user.cell}")
			UserCardText(text = "Email:  ${user.email}")
			UserCardText(text = "Postcode:  ${user.postcode}")
		}
		InfoCard(title = "Location") {
			UserCardText(text = "Country:  ${user.country}")
			UserCardText(text = "State:  ${user.state}")
			UserCardText(text = "City:  ${user.city}")
			UserCardText(text = "Address:  ${user.streetName} ${user.streetNumber}")
			UserCardText(text = "Coordinates:  ${user.latitude} ${user.longitude}")
			UserCardText(text = "Timezone:  ${user.timezoneOffset} ${user.timezoneDescription}")
		}
		InfoCard(title = "Account Info") {
			UserCardText(text = "UUID:  ${user.uuid}")
			UserCardText(text = "Username: ${user.username}")

			var showPassword by remember {
				mutableStateOf(false)
			}

			Box(
				modifier = Modifier
					.clickable {
						showPassword = !showPassword
					}
			) {
				UserCardText(text = "Password:  ${
					if (showPassword) user.password else "*************"
				}")
			}

			UserCardText(text = "Register Age:  ${user.registerAge}")
			UserCardText(text = "Registered:  ${user.registerDate}")
		}
	}
}


@Composable
fun InfoCard(
	title: String?,
	content: @Composable () -> Unit
) {
	Card(
		modifier = Modifier
			.padding(8.dp)
			.fillMaxWidth()
	) {
		Column(
			Modifier.padding(8.dp)
		) {
			title?.let {
				UserCardText(text = it, isTitle = true)
			}
			content()
		}
	}
}
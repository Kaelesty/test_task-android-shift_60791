package com.kaelesty.shift_60791.presentation.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kaelesty.shift_60791.domain.entities.User
import com.kaelesty.shift_60791.presentation.theme.SHIFT60791Theme

@Composable
fun UserCard(user: User) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp)
	) {
		AsyncImage(model = user.picture, contentDescription = "Human photo")
		Text(user.nameFirst)
	}
}

@Preview
@Composable
fun PreviewUserCardDark() {
	SHIFT60791Theme(darkTheme = true) {
		UserCard(user = User())
	}
}

@Preview
@Composable
fun PreviewUserCardLight() {
	SHIFT60791Theme() {
		UserCard(user = User())
	}
}
package com.kaelesty.shift_60791.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kaelesty.shift_60791.domain.entities.User
import com.kaelesty.shift_60791.presentation.theme.SHIFT60791Theme

@Composable
fun UserCard(user: User) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp)
	) {
		Row(
			modifier = Modifier.padding(8.dp)
		) {
			AsyncImage(
				model = user.picture,
				contentDescription = "Human photo",
				modifier = Modifier
					.size(80.dp)
				,
				contentScale = ContentScale.FillBounds
			)
			Spacer(modifier = Modifier.width(8.dp))
			Column {
				UserCardText(
					text = "${user.nameTitle}${if (user.nameTitle.length == 2) "." else ""} ${user.nameFirst} ${user.nameLast}",
					isTitle = true
				)
				UserCardText(
					text = "${user.country}, ${user.state}, ${user.city}, ${user.streetName} ${user.streetNumber}"
				)
				UserCardText(
					text = user.phone
				)
			}
		}
	}
}

@Composable
fun UserCardText(
	text: String,
	isTitle: Boolean = false,
) {
	Text(
		text = text,
		fontSize = if (isTitle) 20.sp else 16.sp,
		fontWeight = if (isTitle) FontWeight.Bold else FontWeight.Normal
	)
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
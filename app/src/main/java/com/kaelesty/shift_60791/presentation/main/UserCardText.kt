package com.kaelesty.shift_60791.presentation.main

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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
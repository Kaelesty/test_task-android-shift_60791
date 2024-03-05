package com.kaelesty.shift_60791.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kaelesty.shift_60791.ShiftApplication
import com.kaelesty.shift_60791.domain.GetRandomUsersUseCase
import com.kaelesty.shift_60791.presentation.theme.SHIFT60791Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

	private val component by lazy {
		(application as ShiftApplication).component
	}

	@Inject lateinit var getRandomUsersUseCase: GetRandomUsersUseCase

	private val scope = CoroutineScope(Dispatchers.IO)

	override fun onCreate(savedInstanceState: Bundle?) {

		component.inject(this@MainActivity)

		scope.launch {
			val users = getRandomUsersUseCase(5)
			users.forEach {
				Log.d("MainActivity.kt", it.toString())
			}
		}

		super.onCreate(savedInstanceState)
		setContent {
			SHIFT60791Theme {

			}
		}
	}
}
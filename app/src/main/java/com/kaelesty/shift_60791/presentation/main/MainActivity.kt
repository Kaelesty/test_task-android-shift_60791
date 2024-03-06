package com.kaelesty.shift_60791.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kaelesty.shift_60791.ShiftApplication
import com.kaelesty.shift_60791.presentation.ViewModelFactory
import com.kaelesty.shift_60791.presentation.theme.SHIFT60791Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

	private val component by lazy {
		(application as ShiftApplication).component
	}

	private val scope = CoroutineScope(Dispatchers.IO)

	@Inject lateinit var viewModelFactory: ViewModelFactory

	override fun onCreate(savedInstanceState: Bundle?) {

		component.inject(this@MainActivity)

		super.onCreate(savedInstanceState)
		setContent {
			SHIFT60791Theme {
				MainScreen(viewModelFactory)
			}
		}
	}
}
package com.kaelesty.shift_60791.presentation.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

	@Inject lateinit var viewModelFactory: ViewModelFactory

	override fun onCreate(savedInstanceState: Bundle?) {

		component.inject(this@MainActivity)

		super.onCreate(savedInstanceState)
		setContent {
			SHIFT60791Theme {
				MainScreen(
					viewModelFactory,
					onLocationClicked = { latitude, longitude, address ->
						runMaps(latitude, longitude, address)
					},
					onEmailClicked = {
						runEmail(it)
					},
					onPhoneClicked = { runPhone(it) }
				)
			}
		}
	}

	private fun runPhone(phone: String) {
		try {
			startActivity(
				Intent(
					Intent.ACTION_DIAL,
					Uri.parse("tel:${phone}")
				)
			)
		}
		catch (e: Exception) {
			Toast.makeText(this@MainActivity, "Can't open phone app", Toast.LENGTH_LONG).show()
		}
	}

	private fun runEmail(email: String) {
		try {
			startActivity(
				Intent(
					Intent.ACTION_SENDTO,
					Uri.fromParts("mailto", email, null)
				)
			)
		}
		catch (e: Exception) {
			Toast.makeText(this@MainActivity, "Can't open email app", Toast.LENGTH_LONG).show()
		}
	}

	private fun runMaps(latitude: String, longitude: String, address: String) {
		try {
			startActivity(
				Intent(
					Intent.ACTION_VIEW,
					Uri.parse("geo:${latitude},${longitude}?q=${address}")
				)
			)
		}
		catch (e: Exception) {
			Toast.makeText(this@MainActivity, "Can't open navigation app", Toast.LENGTH_LONG).show()
		}
	}
}
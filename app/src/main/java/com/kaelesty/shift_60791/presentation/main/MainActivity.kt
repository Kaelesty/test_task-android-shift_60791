package com.kaelesty.shift_60791.presentation.main

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.kaelesty.shift_60791.ShiftApplication
import com.kaelesty.shift_60791.presentation.ViewModelFactory
import com.kaelesty.shift_60791.presentation.theme.SHIFT60791Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.notify
import javax.inject.Inject

class MainActivity : ComponentActivity() {

	private val NOTIFICATION_CHANNEL_ID = "42"
	private val NOTIFICATION_CHANNEL_NAME = "Main"

	private val component by lazy {
		(application as ShiftApplication).component
	}

	@Inject
	lateinit var viewModelFactory: ViewModelFactory

	private lateinit var viewModel: MainViewModel

	private val scope = CoroutineScope(Dispatchers.IO)

	override fun onCreate(savedInstanceState: Bundle?) {

		component.inject(this@MainActivity)

		viewModel = viewModelFactory.create(MainViewModel::class.java)

		super.onCreate(savedInstanceState)

		scope.launch {
			viewModel.notificationFlow.collect {
				sendNotification("Shift", it)
			}
		}

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
					onPhoneClicked = { runPhone(it) },
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
		} catch (e: Exception) {
			sendNotification("Shift", "Can't open phone app")
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
		} catch (e: Exception) {
			sendNotification("Shift", "Can't open email app")
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
		} catch (e: Exception) {
			sendNotification("Shift", "Can't open navigation app")
		}
	}

	private fun sendNotification(title: String, text: String) {
		var builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
			val notificationChannel = NotificationChannel(
				NOTIFICATION_CHANNEL_ID,
				NOTIFICATION_CHANNEL_NAME,
				NotificationManager.IMPORTANCE_DEFAULT
			)
			notificationManager.createNotificationChannel(notificationChannel)
			NotificationCompat.Builder(this@MainActivity, NOTIFICATION_CHANNEL_ID)
		} else {
			NotificationCompat.Builder(this@MainActivity)
		}

		builder
			.setContentTitle(title)
			.setSmallIcon(android.R.drawable.sym_def_app_icon)
			.setContentText(text)
			.setPriority(NotificationCompat.PRIORITY_HIGH)

		if (ActivityCompat.checkSelfPermission(
				this,
				android.Manifest.permission.POST_NOTIFICATIONS
			) == PackageManager.PERMISSION_GRANTED
		) {
			NotificationManagerCompat.from(this@MainActivity).notify(43, builder.build())
		}
	}
}
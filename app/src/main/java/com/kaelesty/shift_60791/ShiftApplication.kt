package com.kaelesty.shift_60791

import android.app.Application
import androidx.room.Room
import com.kaelesty.shift_60791.data.local.dbs.UserDatabase
import com.kaelesty.shift_60791.di.DaggerApplicationComponent


class ShiftApplication: Application() {

	val component by lazy {
		DaggerApplicationComponent.factory().create(
			this@ShiftApplication,
			Room.databaseBuilder(this, UserDatabase::class.java, "userdb")
				.build()
		)
	}
}
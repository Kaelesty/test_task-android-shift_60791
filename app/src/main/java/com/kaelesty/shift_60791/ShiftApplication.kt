package com.kaelesty.shift_60791

import android.app.Application
import com.kaelesty.shift_60791.di.DaggerApplicationComponent


class ShiftApplication: Application() {

	val component by lazy {
		DaggerApplicationComponent.factory().create(this@ShiftApplication)
	}
}
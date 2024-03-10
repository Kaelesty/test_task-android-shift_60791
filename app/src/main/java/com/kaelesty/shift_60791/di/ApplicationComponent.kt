package com.kaelesty.shift_60791.di

import android.app.Application
import com.kaelesty.shift_60791.data.local.dbs.UserDatabase
import com.kaelesty.shift_60791.presentation.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
	modules = [
		RemoteModule::class,
		DomainModule::class,
		LocalModule::class,
		ViewModelModule::class,
	]
)
interface ApplicationComponent {

	fun inject(activity: MainActivity)

	@Component.Factory
	interface ApplicationComponentFactory {

		fun create(
			@BindsInstance application: Application,
			@BindsInstance userDb: UserDatabase,
		): ApplicationComponent
	}
}
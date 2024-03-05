package com.kaelesty.shift_60791.di

import android.app.Application
import com.kaelesty.shift_60791.presentation.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject

@ApplicationScope
@Component(
	modules = [
		RemoteModule::class,
		DomainModule::class,
	]
)
interface ApplicationComponent {

	fun inject(activity: MainActivity)

	@Component.Factory
	interface ApplicationComponentFactory {

		fun create(
			@BindsInstance application: Application
		): ApplicationComponent
	}
}
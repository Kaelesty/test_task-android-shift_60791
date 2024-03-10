package com.kaelesty.shift_60791.di

import androidx.lifecycle.ViewModel
import com.kaelesty.shift_60791.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {

	@IntoMap
	@StringKey("MainViewModel")
	@Binds
	fun bindsMusicViewModel(impl: MainViewModel): ViewModel
}
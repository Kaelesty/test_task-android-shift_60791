package com.kaelesty.shift_60791.di

import com.kaelesty.shift_60791.data.remote.RandomUserApiFactory
import dagger.Module
import dagger.Provides

@Module
class RemoteModule {

	@Provides
	fun provideRandomUserApiService() = RandomUserApiFactory.randomUserService
}
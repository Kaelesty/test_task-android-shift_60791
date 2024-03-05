package com.kaelesty.shift_60791.di

import com.kaelesty.shift_60791.data.remote.RandomUserApiFactory
import com.kaelesty.shift_60791.data.repos.UsersRepo
import com.kaelesty.shift_60791.domain.IUsersRepo
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

	@Provides
	fun provideRandomIUsersRepo(impl: UsersRepo): IUsersRepo = impl
}
package com.kaelesty.shift_60791.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.kaelesty.shift_60791.data.local.dbs.UserDatabase
import com.kaelesty.shift_60791.data.remote.RandomUserApiFactory
import dagger.Module
import dagger.Provides

@Module
class LocalModule {

	@Provides
	fun provideUserDao(db: UserDatabase) = db.userDao()
}
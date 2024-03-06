package com.kaelesty.shift_60791.data.local.dbs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kaelesty.shift_60791.data.local.daos.IUserDao
import com.kaelesty.shift_60791.data.local.dbmodels.UserDbModel

@Database(
	entities = [UserDbModel::class],
	version = 1,
	exportSchema = false,
)
abstract class UserDatabase: RoomDatabase() {

	abstract fun userDao(): IUserDao
}
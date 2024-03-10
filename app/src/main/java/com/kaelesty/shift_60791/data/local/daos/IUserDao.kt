package com.kaelesty.shift_60791.data.local.daos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.kaelesty.shift_60791.data.local.dbmodels.UserDbModel
import androidx.room.Query

@Dao
interface IUserDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun addUser(user: UserDbModel)

	@Query("DELETE from users WHERE id = :userId")
	fun deleteUser(userId: Int)

	@Query("SELECT * from users")
	fun getUsers(): List<UserDbModel>
}
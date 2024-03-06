package com.kaelesty.shift_60791.data.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.kaelesty.shift_60791.data.local.daos.IUserDao
import com.kaelesty.shift_60791.data.remote.RandomUserApiService
import com.kaelesty.shift_60791.data.tools.UserMapper
import com.kaelesty.shift_60791.domain.IUsersRepo
import com.kaelesty.shift_60791.domain.entities.User
import javax.inject.Inject

class UsersRepo @Inject constructor(
	private val apiService: RandomUserApiService,
	private val userDao: IUserDao
): IUsersRepo {

	private val USERS_COUNT = 50

	private suspend fun getRandomUsers(count: Int): List<User> {

		return try {
			val response = apiService.getRandomUsers(count)

			when (response.code()) {
				200 -> response.body()?.results?.map {
					UserMapper.userDtoToDomain(it)
				} ?: listOf()

				else -> listOf()
			}
		} catch (e: Exception) {
			Log.d("SHIFTtag", e.message.toString())
			listOf()
		}
	}

	override fun getUsers(): LiveData<List<User>> {
		return userDao.getUsers().map {
			it.map {
				UserMapper.userDbModelToDomain(it)
			}
		}
	}

	override suspend fun reloadUsers() {
		userDao.getUsers().value?.forEach {
			userDao.deleteUser(it.id)
		}

		val users = getRandomUsers(USERS_COUNT)
		users.forEachIndexed { index, user ->
			userDao.addUser(UserMapper.userDomainToDbModel(index, user))
		}
	}
}
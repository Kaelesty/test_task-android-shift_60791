package com.kaelesty.shift_60791.data.repos

import android.util.Log
import com.kaelesty.shift_60791.data.remote.RandomUserApiService
import com.kaelesty.shift_60791.data.tools.UserMapper
import com.kaelesty.shift_60791.domain.IUsersRepo
import com.kaelesty.shift_60791.domain.entities.User
import javax.inject.Inject

class UsersRepo @Inject constructor(
	private val apiService: RandomUserApiService
): IUsersRepo {

	override suspend fun getRandomUsers(count: Int): List<User> {

		return try {
			val response = apiService.getRandomUsers(count)

			when (response.code()) {
				200 -> response.body()?.results?.map {
					UserMapper.userDtoToDomain(it)
				} ?: listOf()

				else -> listOf()
			}
		} catch (e: Exception) {
			listOf()
		}
	}
}
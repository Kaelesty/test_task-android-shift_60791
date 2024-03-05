package com.kaelesty.shift_60791.domain

import com.kaelesty.shift_60791.domain.entities.User

interface IUsersRepo {

	suspend fun getRandomUsers(count: Int): List<User>
}
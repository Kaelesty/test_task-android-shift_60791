package com.kaelesty.shift_60791.domain

import com.kaelesty.shift_60791.domain.entities.User
import javax.inject.Inject

class GetRandomUsersUseCase @Inject constructor(val repo: IUsersRepo) {

	suspend operator fun invoke(count: Int): List<User> = repo.getRandomUsers(count)
}
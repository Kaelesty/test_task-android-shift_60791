package com.kaelesty.shift_60791.domain

import com.kaelesty.shift_60791.domain.entities.User
import javax.inject.Inject

class ReloadUsersUseCase @Inject constructor(val repo: IUsersRepo) {

	suspend operator fun invoke() = repo.reloadUsers()
}
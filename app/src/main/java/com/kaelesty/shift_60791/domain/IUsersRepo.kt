package com.kaelesty.shift_60791.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kaelesty.shift_60791.domain.entities.User

interface IUsersRepo {

	suspend fun getUsers(): List<User>

	suspend fun reloadUsers()
}
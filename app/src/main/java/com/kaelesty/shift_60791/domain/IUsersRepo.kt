package com.kaelesty.shift_60791.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kaelesty.shift_60791.domain.entities.User

interface IUsersRepo {

	fun getUsers(): LiveData<List<User>>

	suspend fun reloadUsers()
}
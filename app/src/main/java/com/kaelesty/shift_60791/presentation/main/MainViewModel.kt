package com.kaelesty.shift_60791.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kaelesty.shift_60791.domain.GetUsersUseCase
import com.kaelesty.shift_60791.domain.ReloadUsersUseCase
import com.kaelesty.shift_60791.domain.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
	private val reloadUsersUseCase: ReloadUsersUseCase,
	private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

	val users = getUsersUseCase()

	fun checkEmptyUsersList() {
		val uList = users.value?: listOf()
		if (uList.isEmpty()) {
			reloadUsers()
		}
	}

	fun reloadUsers() {
		viewModelScope.launch(Dispatchers.IO) {
			reloadUsersUseCase()
		}
	}
}
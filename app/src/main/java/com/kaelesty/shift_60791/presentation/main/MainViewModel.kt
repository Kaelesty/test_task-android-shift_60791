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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
	private val reloadUsersUseCase: ReloadUsersUseCase,
	private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

	private val _usersFlow: MutableStateFlow<List<User>> = MutableStateFlow(listOf())
	val usersFlow: StateFlow<List<User>> get() = _usersFlow

	private val _userFlow: MutableStateFlow<User> = MutableStateFlow(User(0))
	val userFlow: StateFlow<User> get() = _userFlow

	private val _notificationFlow: MutableSharedFlow<String> = MutableSharedFlow()
	val notificationFlow: SharedFlow<String> get() = _notificationFlow

	fun loadUsers(reloadIfNotEmpty: Boolean = false) {
		viewModelScope.launch(Dispatchers.IO) {
			val users = getUsersUseCase()

			_usersFlow.emit (
				if (users.isNotEmpty() && !reloadIfNotEmpty) {
					_notificationFlow.emit("Loading data from database...")
					users
				} else {
					_notificationFlow.emit("Loading data from internet...")
					reloadUsersUseCase()
					getUsersUseCase()
				}
			)
		}
	}

	fun setUserToShowDetails(user: User) {
		viewModelScope.launch(Dispatchers.IO) {
			_notificationFlow.emit("Loading user ${user.username}")
			_userFlow.emit(user)
		}
	}
}
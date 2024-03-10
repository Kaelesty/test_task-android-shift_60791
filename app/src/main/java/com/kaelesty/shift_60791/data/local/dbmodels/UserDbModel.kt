package com.kaelesty.shift_60791.data.local.dbmodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbModel(
	@PrimaryKey val id: Int,
	val gender: String,
	val email: String,
	val phone: String,
	val cell: String,
	val picture: String,
	val city: String,
	val state: String,
	val country: String,
	val postcode: String,
	val latitude: Float,
	val longitude: Float,
	val timezoneOffset: String,
	val timezoneDescription: String,
	val streetNumber: Int,
	val streetName: String,
	val birthday: String,
	val age: Int,
	val registerDate: String,
	val registerAge: Int,
	val username: String,
	val password: String,
	val uuid: String,
	val nameTitle: String,
	val nameFirst: String,
	val nameLast: String
)
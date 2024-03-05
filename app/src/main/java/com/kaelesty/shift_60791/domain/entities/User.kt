package com.kaelesty.shift_60791.domain.entities

data class User(
	val gender: String,
	val email: String,
	val phone: String,
	val cell: String,
	val picture: String,
	val city: String,
	val state: String,
	val country: String,
	val postcode: Int,
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
)

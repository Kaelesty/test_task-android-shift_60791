package com.kaelesty.shift_60791.domain.entities

data class User(
	val id: Int,
	val gender: String = "Male", //
	val email: String = "email@email.com", //
	val phone: String = "88976674", //
	val cell: String = "88976674", //
	val picture: String = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.interaction-design.org%2Fliterature%2Ftopics%2Fhuman-computer-interaction&psig=AOvVaw0-fkhfUywGSONpkt11tyh6&ust=1709798073826000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCKDikqiU34QDFQAAAAAdAAAAABAF",
	val city: String = "Phoenix", //
	val state: String = "Texas", //
	val country: String = "USA", //
	val postcode: String = "R34 T33", //
	val latitude: Float = 3535.34f, //
	val longitude: Float = 3535.34f, //
	val timezoneOffset: String = "UTF -5", //
	val timezoneDescription: String = "Phoenix, Texas", //
	val streetNumber: Int = 45, //
	val streetName: String = "Lee Ave.", //
	val birthday: String = "26.07.2000", //
	val age: Int = 24, //
	val registerDate: String = "15.01.2015", //
	val registerAge: Int = 9, //
	val username: String = "ivycorsa342", //
	val password: String = "gWAfy6$4dfbipWEA^#", //
	val uuid: String = "5325-3248-1244-5444",
	val nameTitle: String = "Mr. ", //
	val nameFirst: String = "Ivy", //
	val nameLast: String = "Corsa" //
)

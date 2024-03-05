package com.kaelesty.shift_60791.data.dtos

import com.google.gson.annotations.SerializedName

data class GetRandomUsersResponse(
	@SerializedName("results") val results: List<UserResult>,
)

data class UserResult(
	@SerializedName("gender") val gender: String,
	@SerializedName("name") val name: UserName,
	@SerializedName("location") val location: Location,
	@SerializedName("email") val email: String,
	@SerializedName("login") val login: Login,
	@SerializedName("dob") val birthday: Timestamp,
	@SerializedName("registered") val registered: Timestamp,
	@SerializedName("phone") val phone: String,
	@SerializedName("cell") val cell: String,
	@SerializedName("picture") val picture: Picture,
)

data class UserName(
	@SerializedName("title") val title: String,
	@SerializedName("first") val first: String,
	@SerializedName("last") val last: String,
)

data class Location(
	@SerializedName("street") val street: UserStreet,
	@SerializedName("city") val city: String,
	@SerializedName("state") val state: String,
	@SerializedName("country") val country: String,
	@SerializedName("postcode") val postcode: Int,
	@SerializedName("coordinates") val coordinates: Coordinates,
	@SerializedName("timezone") val timezone: Timezone
)

data class UserStreet(
	@SerializedName("number") val number: Int,
	@SerializedName("name") val name: String,
)

data class Coordinates(
	@SerializedName("latitude") val latitude: Float,
	@SerializedName("longitude") val longitude: Float
)

data class Timezone(
	@SerializedName("offset") val offset: String,
	@SerializedName("description") val description: String,
)

data class Login(
	@SerializedName("uuid") val uuid: String,
	@SerializedName("username") val username: String,
	@SerializedName("password") val password: String,
)

data class Timestamp(
	@SerializedName("date") val date: String,
	@SerializedName("age") val age: Int,
)

data class Picture(
	@SerializedName("large") val large: String
)
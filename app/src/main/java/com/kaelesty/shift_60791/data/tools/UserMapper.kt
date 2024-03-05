package com.kaelesty.shift_60791.data.tools

import com.kaelesty.shift_60791.data.dtos.UserResult
import com.kaelesty.shift_60791.domain.entities.User

object UserMapper {

	fun userDtoToDomain(dto: UserResult) = User(
		email = dto.email,
		cell = dto.cell,
		phone = dto.phone,
		gender = dto.gender,
		picture = dto.picture.large,
		city = dto.location.city,
		country = dto.location.country,
		postcode = dto.location.postcode,
		latitude = dto.location.coordinates.latitude,
		longitude = dto.location.coordinates.longitude,
		timezoneOffset = dto.location.timezone.offset,
		timezoneDescription = dto.location.timezone.offset,
		streetName = dto.location.street.name,
		streetNumber = dto.location.street.number,
		state = dto.location.state,
		age = dto.birthday.age,
		birthday = dto.birthday.date,
		registerAge = dto.registered.age,
		registerDate = dto.registered.date
	)
}
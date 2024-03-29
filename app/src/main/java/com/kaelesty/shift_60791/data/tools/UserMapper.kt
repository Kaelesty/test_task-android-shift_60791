package com.kaelesty.shift_60791.data.tools

import com.kaelesty.shift_60791.data.dtos.UserResult
import com.kaelesty.shift_60791.data.local.dbmodels.UserDbModel
import com.kaelesty.shift_60791.domain.entities.User

object UserMapper {

	fun userDtoToDomain(dto: UserResult, id: Int = -1) = User(
		id = id,
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
		timezoneDescription = dto.location.timezone.description,
		streetName = dto.location.street.name,
		streetNumber = dto.location.street.number,
		state = dto.location.state,
		age = dto.birthday.age,
		birthday = dto.birthday.date,
		registerAge = dto.registered.age,
		registerDate = dto.registered.date,
		username = dto.login.username,
		password = dto.login.password,
		uuid = dto.login.uuid,
		nameFirst = dto.name.first,
		nameLast = dto.name.last,
		nameTitle = dto.name.title,
	)

	fun userDbModelToDomain(dbModel: UserDbModel) = User(
		id = dbModel.id,
		email = dbModel.email,
		cell = dbModel.cell,
		phone = dbModel.phone,
		gender = dbModel.gender,
		picture = dbModel.picture,
		city = dbModel.city,
		country = dbModel.country,
		postcode = dbModel.postcode,
		latitude = dbModel.latitude,
		longitude = dbModel.longitude,
		timezoneOffset = dbModel.timezoneOffset,
		timezoneDescription = dbModel.timezoneDescription,
		streetName = dbModel.streetName,
		streetNumber = dbModel.streetNumber,
		state = dbModel.state,
		age = dbModel.age,
		birthday = dbModel.birthday,
		registerAge = dbModel.registerAge,
		registerDate = dbModel.registerDate,
		username = dbModel.username,
		password = dbModel.password,
		uuid = dbModel.uuid,
		nameTitle = dbModel.nameTitle,
		nameLast = dbModel.nameLast,
		nameFirst = dbModel.nameFirst,
	)

	fun userDomainToDbModel(domain: User) = UserDbModel(
		id = domain.id,
		email = domain.email,
		cell = domain.cell,
		phone = domain.phone,
		gender = domain.gender,
		picture = domain.picture,
		city = domain.city,
		country = domain.country,
		postcode = domain.postcode,
		latitude = domain.latitude,
		longitude = domain.longitude,
		timezoneOffset = domain.timezoneOffset,
		timezoneDescription = domain.timezoneDescription,
		streetName = domain.streetName,
		streetNumber = domain.streetNumber,
		state = domain.state,
		age = domain.age,
		birthday = domain.birthday,
		registerAge = domain.registerAge,
		registerDate = domain.registerDate,
		username = domain.username,
		password = domain.password,
		uuid = domain.uuid,
		nameFirst = domain.nameFirst,
		nameLast = domain.nameLast,
		nameTitle = domain.nameTitle,
	)
}
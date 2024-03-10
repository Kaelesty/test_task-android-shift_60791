package com.kaelesty.shift_60791.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RandomUserApiFactory {

	private val SERVER_URL = "https://randomuser.me/"

	val randomUserService: RandomUserApiService = Retrofit.Builder()
		.baseUrl(SERVER_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.build()
		.create(RandomUserApiService::class.java)
}
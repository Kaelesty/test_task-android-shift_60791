package com.kaelesty.shift_60791.data.remote

import com.kaelesty.shift_60791.data.dtos.GetRandomUsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApiService {

	@GET("api/")
	suspend fun getRandomUsers(@Query("results") count: Int): Response<GetRandomUsersResponse>
}
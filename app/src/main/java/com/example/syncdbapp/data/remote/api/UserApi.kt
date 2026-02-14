package com.example.syncdbapp.data.remote.api

import kotlinx.coroutines.delay
import retrofit2.http.Body

interface UserApi {
    // @POST("/actions")
    suspend fun uploadAction(@Body payload: String) {
        delay(5000)
    }
}

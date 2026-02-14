package com.example.syncdbapp.domain.repository

interface UserActionRepository {
    suspend fun saveLocally(payload: String)
    suspend fun syncPending()
}

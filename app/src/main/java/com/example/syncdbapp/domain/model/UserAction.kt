package com.example.syncdbapp.domain.model

data class UserAction(
    val id: String,
    val payload: String,
    val syncState: SyncState,
    val createdAt: Long
)

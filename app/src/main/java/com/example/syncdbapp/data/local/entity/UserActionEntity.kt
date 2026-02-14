package com.example.syncdbapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.syncdbapp.domain.model.SyncState

@Entity(tableName = "user_actions")
data class UserActionEntity(
    @PrimaryKey val id: String,
    val payload: String,
    val syncState: SyncState,
    val createdAt: Long
)

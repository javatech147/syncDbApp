package com.example.syncdbapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.syncdbapp.data.local.entity.UserActionEntity
import com.example.syncdbapp.domain.model.SyncState

@Dao
interface UserActionDao {

    @Query("SELECT * FROM user_actions WHERE syncState = :state")
    suspend fun getByState(state: SyncState): List<UserActionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: UserActionEntity)

    @Query("UPDATE user_actions SET syncState = :state WHERE id = :id")
    suspend fun updateState(id: String, state: SyncState)
}

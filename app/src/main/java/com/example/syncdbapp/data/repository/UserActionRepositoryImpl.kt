package com.example.syncdbapp.data.repository

import com.example.syncdbapp.data.local.dao.UserActionDao
import com.example.syncdbapp.data.local.entity.UserActionEntity
import com.example.syncdbapp.data.remote.api.UserApi
import com.example.syncdbapp.domain.model.SyncState
import com.example.syncdbapp.domain.repository.UserActionRepository
import java.util.UUID
import javax.inject.Inject

class UserActionRepositoryImpl @Inject constructor(
    private val dao: UserActionDao,
    private val api: UserApi
) : UserActionRepository {

    override suspend fun saveLocally(payload: String) {
        dao.insert(
            entity = UserActionEntity(
                id = UUID.randomUUID().toString(),
                payload = payload,
                syncState = SyncState.PENDING,
                createdAt = System.currentTimeMillis()
            )
        )
    }

    override suspend fun syncPending() {
        val pending = dao.getByState(state = SyncState.PENDING)
        pending.forEach { entity ->
            dao.updateState(id = entity.id, state = SyncState.SYNCING)
            try {
                api.uploadAction(entity.payload)
                dao.updateState(id = entity.id, state = SyncState.SYNCED)
            } catch (e: Exception) {
                dao.updateState(id = entity.id, state = SyncState.PENDING)
                throw e
            }
        }
    }
}

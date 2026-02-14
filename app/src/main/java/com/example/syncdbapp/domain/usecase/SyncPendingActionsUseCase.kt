package com.example.syncdbapp.domain.usecase

import com.example.syncdbapp.domain.repository.UserActionRepository

class SyncPendingActionsUseCase(
    private val repository: UserActionRepository
) {
    suspend operator fun invoke() {
        repository.syncPending()
    }
}

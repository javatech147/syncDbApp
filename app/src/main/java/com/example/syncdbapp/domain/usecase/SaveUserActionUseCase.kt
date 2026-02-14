package com.example.syncdbapp.domain.usecase

import com.example.syncdbapp.domain.repository.UserActionRepository
import javax.inject.Inject

class SaveUserActionUseCase @Inject constructor(
    private val repository: UserActionRepository
) {
    suspend operator fun invoke(payload: String) {
        repository.saveLocally(payload)
    }
}

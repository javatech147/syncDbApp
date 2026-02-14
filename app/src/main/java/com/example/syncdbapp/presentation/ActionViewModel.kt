package com.example.syncdbapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.syncdbapp.domain.usecase.EnqueueSyncUseCase
import com.example.syncdbapp.domain.usecase.SaveUserActionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActionViewModel @Inject constructor(
    private val saveUseCase: SaveUserActionUseCase,
    private val enqueueSyncUseCase: EnqueueSyncUseCase
) : ViewModel() {

    fun submitAction(payload: String) {
        viewModelScope.launch {
            saveUseCase(payload)
            enqueueSyncUseCase()
        }
    }
}

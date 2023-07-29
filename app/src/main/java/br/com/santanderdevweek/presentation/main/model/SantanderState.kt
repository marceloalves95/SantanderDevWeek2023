package br.com.santanderdevweek.presentation.main.model

import br.com.santanderdevweek.domain.models.Santander

sealed class SantanderState {
    object Loading: SantanderState()
    data class ScreenData(val screenData: Santander) : SantanderState()
    data class Error(val exception: Throwable? = null) : SantanderState()
}
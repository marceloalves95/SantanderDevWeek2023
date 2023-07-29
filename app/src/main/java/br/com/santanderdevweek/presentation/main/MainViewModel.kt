package br.com.santanderdevweek.presentation.main

import androidx.lifecycle.ViewModel
import br.com.santanderdevweek.domain.usecases.GetSantanderUseCase
import br.com.santanderdevweek.extensions.others.launch
import br.com.santanderdevweek.network.event.Event
import br.com.santanderdevweek.presentation.main.model.SantanderState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val getSantanderUseCase: GetSantanderUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<SantanderState>(SantanderState.Loading)
    val state: StateFlow<SantanderState> get() = _state

    fun loadScreen() = launch {
        getSantanderUseCase.invoke().collect { event ->
            when (event) {
                is Event.Loading -> {
                    _state.value = SantanderState.Loading
                }

                is Event.Data -> {
                    _state.value = SantanderState.ScreenData(event.data)
                }

                is Event.Error -> {
                    _state.value = SantanderState.Error(event.error)
                }
            }
        }
    }
}
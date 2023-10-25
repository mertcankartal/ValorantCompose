package com.example.valorantcompose.presentation.agents

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcompose.common.Resource
import com.example.valorantcompose.domain.usecase.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AgentsScreenViewModel @Inject constructor(private val useCase: GetAgentsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(AgentsState())
    val state: State<AgentsState> = _state

    init {
        getAgents()
    }
    private fun getAgents() {
        useCase.invoke().onEach {
            when(it) {
                is Resource.Error -> {
                    _state.value = AgentsState(errorMessage = it.message ?: "Error")
                }
                is Resource.Success -> {
                    _state.value = AgentsState(agentsList = it.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = AgentsState(loading = true)
                }
                else -> {}
            }

        }.launchIn(viewModelScope)
    }

}
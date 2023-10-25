package com.example.valorantcompose.presentation.agents.agentdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcompose.common.Resource
import com.example.valorantcompose.domain.usecase.GetAgentDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val useCase: GetAgentDetailUseCase,
    private val stateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _state = mutableStateOf(AgentDetailState())
    val state: State<AgentDetailState> = _state

    init {
        getAgentDetail()
    }
    fun getAgentDetail() {
        stateHandle.get<String>("uuid")?.let {
            useCase.invoke(it).onEach {agent ->
                when (agent) {
                    is Resource.Error -> { _state.value = AgentDetailState(errorMessage = agent.message)}
                    is Resource.Loading -> { _state.value = AgentDetailState(loading = true)}
                    is Resource.Success -> { _state.value = AgentDetailState(agent = agent.data)}
                    else -> {}
                }

            }.launchIn(viewModelScope)
        }
    }
}
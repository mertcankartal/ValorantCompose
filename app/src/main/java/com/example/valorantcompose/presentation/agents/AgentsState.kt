package com.example.valorantcompose.presentation.agents

import com.example.valorantcompose.domain.model.agents.AgentsDto

data class AgentsState(
    val loading: Boolean = false,
    val errorMessage: String = "",
    val agentsList: List<AgentsDto> = emptyList()
)

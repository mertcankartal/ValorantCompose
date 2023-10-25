package com.example.valorantcompose.presentation.agents.agentdetail

import com.example.valorantcompose.domain.model.agents.AgentsDto

data class AgentDetailState(
    val loading: Boolean? = true,
    val errorMessage:String? = "",
    val agent: AgentsDto? = AgentsDto()
)

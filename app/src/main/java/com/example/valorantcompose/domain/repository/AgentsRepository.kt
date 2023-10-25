package com.example.valorantcompose.domain.repository

import com.example.valorantcompose.data.model.agents.AgentsResponse
import com.example.valorantcompose.data.model.agents.agentsdetail.AgentsDetailResponse

interface AgentsRepository {

    suspend fun getAgents() : AgentsResponse

    suspend fun getAgentDetail(uuid: String) : AgentsDetailResponse
}
package com.example.valorantcompose.data.repository

import com.example.valorantcompose.data.model.agents.AgentsResponse
import com.example.valorantcompose.data.model.agents.agentsdetail.AgentsDetailResponse
import com.example.valorantcompose.data.remote.ServiceDataSource
import com.example.valorantcompose.domain.repository.AgentsRepository
import javax.inject.Inject

class AgentsRepositoryImpl @Inject constructor(val dataSource: ServiceDataSource): AgentsRepository {
    override suspend fun getAgents(): AgentsResponse {
        return dataSource.getAgents()
    }

    override suspend fun getAgentDetail(uuid: String): AgentsDetailResponse {
        return dataSource.getAgentDetail(uuid)
    }
}
package com.example.valorantcompose.data.remote

import com.example.valorantcompose.data.model.agents.AgentsResponse
import com.example.valorantcompose.data.model.agents.agentsdetail.AgentsDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ServiceDataSource @Inject constructor(val api: ServiceApi) {

    suspend fun getAgents(): AgentsResponse = api.getAgents()

    suspend fun getAgentDetail(uuid: String): AgentsDetailResponse = withContext(Dispatchers.IO) {
        api.getAgentDetail(uuid)
    }
}
package com.example.valorantcompose.data.remote

import com.example.valorantcompose.data.model.agents.AgentsResponse
import com.example.valorantcompose.data.model.agents.agentsdetail.AgentsDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {
    @GET("agents")
    suspend fun getAgents(): AgentsResponse

    @GET("agents/{uuid}")
    suspend fun getAgentDetail(@Path("uuid") uuid:String) : AgentsDetailResponse
}
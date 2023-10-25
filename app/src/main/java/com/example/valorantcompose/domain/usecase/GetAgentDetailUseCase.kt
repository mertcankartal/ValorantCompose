package com.example.valorantcompose.domain.usecase

import com.example.valorantcompose.common.Resource
import com.example.valorantcompose.data.model.agents.agentsdetail.toAgentDetailDto
import com.example.valorantcompose.domain.model.agents.AgentsDto
import com.example.valorantcompose.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAgentDetailUseCase @Inject constructor(val repository: AgentsRepository){

    operator fun invoke(uuid:String) : Flow<Resource<AgentsDto>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getAgentDetail(uuid)
            emit(Resource.Success(response.toAgentDetailDto()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Exception error !!!"))
        }
    }
}
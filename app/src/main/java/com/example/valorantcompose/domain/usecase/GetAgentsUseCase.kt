package com.example.valorantcompose.domain.usecase

import com.example.valorantcompose.common.Resource
import com.example.valorantcompose.data.model.agents.toAgentsDto
import com.example.valorantcompose.domain.model.agents.AgentsDto
import com.example.valorantcompose.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(private val repository: AgentsRepository) {

     operator fun invoke(): Flow<Resource<List<AgentsDto>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getAgents()
            emit(Resource.Success(response.toAgentsDto()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message()))
        }
    }
}
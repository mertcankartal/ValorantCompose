package com.example.valorantcompose.data.model.agents.agentsdetail

import com.example.valorantcompose.domain.model.agents.AbilityDto
import com.example.valorantcompose.domain.model.agents.AgentsDto
import com.example.valorantcompose.domain.model.agents.RoleDto
import com.google.gson.annotations.SerializedName

data class AgentsDetailResponse(
    @SerializedName("data")
    val data: Data,
    val status: Int
)

fun AgentsDetailResponse.toAgentDetailDto(): AgentsDto {
    return AgentsDto(
        agentName = data.displayName,
        agentDesc = data.description,
        agentDeveloperName = data.developerName,
        agentImage = data.displayIcon,
        agentRole = RoleDto(
            roleName = data.role.displayName,
            description = data.role.description,
            roleIcon = data.role.displayIcon,
            uuid = data.role.uuid
        ),
        abilities = data.abilities.map {
            AbilityDto(abilityName = it.displayName, description = it.description, abilityIcon = it.displayIcon)
        }
    )
}
package com.example.valorantcompose.data.model.agents

import com.example.valorantcompose.domain.model.agents.AbilityDto
import com.example.valorantcompose.domain.model.agents.AgentsDto
import com.example.valorantcompose.domain.model.agents.RoleDto
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AgentsResponse(
    @SerializedName("data")
    val data: List<AgentInformations>,
    val status: Int
) : Serializable

fun AgentsResponse.toAgentsDto(): List<AgentsDto> {
    return data.map { agentsInfo ->
        AgentsDto(
            agentName = agentsInfo.displayName,
            agentDesc = agentsInfo.description,
            agentDeveloperName = agentsInfo.developerName,
            agentImage = agentsInfo.displayIcon,
            agentRole = if (agentsInfo.role != null) {RoleDto(
                roleName = agentsInfo.role.displayName,
                description = agentsInfo.role.description,
                roleIcon = agentsInfo.role.displayIcon,
                uuid = agentsInfo.role.uuid
            )} else { RoleDto() },
            abilities = agentsInfo.abilities.map { ability ->
                AbilityDto(
                    abilityName = ability.displayName,
                    description = ability.description,
                    abilityIcon = ability.displayIcon
                )
            },
            uuid = agentsInfo.uuid
        )
    }
}
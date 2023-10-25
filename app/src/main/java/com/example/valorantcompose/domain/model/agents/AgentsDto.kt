package com.example.valorantcompose.domain.model.agents

data class AgentsDto(
    val agentName: String? = "",
    val agentDesc: String? = "",
    val agentDeveloperName: String? = "",
    val agentImage: String? = "",
    val agentRole: RoleDto? = RoleDto(),
    val abilities: List<AbilityDto>? = emptyList(),
    val uuid: String? = ""
)

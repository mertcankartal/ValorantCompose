package com.example.valorantcompose.common

sealed class Screen(val route: String) {
    object AgentsScreen : Screen("agents_screen")
    object AgentDetailScreen : Screen("agent_detail_screen")
}

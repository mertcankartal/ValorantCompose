package com.example.valorantcompose.presentation.agents.agentdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AgentDetailScreen(
    viewModel: AgentDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box (modifier = Modifier.fillMaxSize()){
        Text(text = state.agent?.agentDesc.toString())

    }

}
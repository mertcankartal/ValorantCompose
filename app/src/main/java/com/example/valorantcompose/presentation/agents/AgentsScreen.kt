package com.example.valorantcompose.presentation.agents

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.valorantcompose.common.Screen
import com.example.valorantcompose.domain.model.agents.AgentsDto
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun AgentsScreen(
    navController: NavController,
    viewModel: AgentsScreenViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        LazyColumn {
            items(state.agentsList) {
                AgentRow(agent = it) {
                    navController.navigate(Screen.AgentDetailScreen.route + "/${it.uuid}")
                }
            }
        }

        if (state.loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AgentRow(
    agent: AgentsDto,
    onClick: (AgentsDto) -> Unit,
) {
    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
            GlideImage(
                model = agent.agentImage,
                contentDescription = "agent_image",
                modifier = Modifier.padding(24.dp)
            )
            Text(
                text = agent.agentName.toString(),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .clickable { onClick(agent) }
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

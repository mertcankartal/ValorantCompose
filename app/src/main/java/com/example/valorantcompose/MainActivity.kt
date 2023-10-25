package com.example.valorantcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.valorantcompose.common.Screen
import com.example.valorantcompose.common.ui.theme.ValorantComposeTheme
import com.example.valorantcompose.presentation.agents.AgentsScreen
import com.example.valorantcompose.presentation.agents.AgentsScreenViewModel
import com.example.valorantcompose.presentation.agents.agentdetail.AgentDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            ValorantComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AgentsScreen.route
                    ) {
                        composable(Screen.AgentsScreen.route) { AgentsScreen(navController) }
                        composable(Screen.AgentDetailScreen.route+"/{uuid}") { AgentDetailScreen() }
                    }
                }
            }
        }
    }
}
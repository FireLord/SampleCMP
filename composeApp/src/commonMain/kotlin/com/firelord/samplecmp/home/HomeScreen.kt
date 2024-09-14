package com.firelord.samplecmp.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.firelord.samplecmp.Greeting
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import samplecmp.composeapp.generated.resources.Res
import samplecmp.composeapp.generated.resources.compose_multiplatform
import kotlin.time.Duration.Companion.seconds

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<HomeViewModel>()
        var showContent by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            delay(1.seconds)
            showContent = true
        }

        Scaffold {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: $greeting")
                    }
                }

                OutlinedTextField(
                    value = viewModel.textFieldText,
                    onValueChange = {
                        viewModel.textFieldText = it
                    },
                    label = {
                        Text("Name")
                    }
                )

                Button(onClick = {
                    viewModel.saveName(viewModel.textFieldText)
                }) {
                    Text("Save name")
                }

                Text(
                    text = "Updated name: ${viewModel.name}",
                )

                Button(onClick = {
                    viewModel.getName()
                }) {
                    Text("Get name")
                }
            }
        }
    }
}
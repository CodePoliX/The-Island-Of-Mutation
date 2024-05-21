package com.example.ailhadamutacao

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.ailhadamutacao.componentes.ChoiceBox
import com.example.ailhadamutacao.componentes.DialogBox

@Composable
fun CenaUm() {
    Box(
        Modifier
            .fillMaxHeight()
            .background(color = Color.Gray)
    ) {
        var storyEvents = listOf(
            StoryEvent.Dialogue(
                "Dalila",
                "Hello, World!",
                R.drawable.dalila_sprite_confusa_foreground
            ),
            StoryEvent.Choice(listOf("Correr", "Andar", "Beijar"), R.drawable.dalila_sprite_confusa_foreground, Alignment.BottomCenter),
            StoryEvent.Dialogue(
                "Aurora",
                "Olá Mundo!",
                R.drawable.dalila_sprite_confusa_foreground
            ),
        )

        // Estado para controlar o índice do evento atual
        var currentEventIndex by remember { mutableStateOf(0) }
        var visibility by remember {
            mutableStateOf(true)
        }

        fun nextEvent() {
            if (currentEventIndex < storyEvents.size - 1) {
                currentEventIndex++
                visibility = true
            }
        }

        val density = LocalDensity.current

        AnimatedVisibility(
            visible = visibility,

            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            when (val event = storyEvents[currentEventIndex]) {
                is StoryEvent.Dialogue -> {
                    DialogBox(
                        nome = event.character,
                        idImagem = event.imagem,
                        fala = event.text,
                        alinhar = Alignment.BottomCenter,
                        onFimFala = {
                            visibility = false // Oculta as escolhas
                            nextEvent() // Avança para o próximo evento
                        }
                    )
                }

                is StoryEvent.Choice -> {
                    ChoiceBox(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        escolhas = event.choices,
                        escolhido = {
                            visibility = false // Oculta as escolhas
                            nextEvent() // Avança para o próximo evento
                        },
                        idImagem = event.imagem,
                        alinhar = event.alinhar
                    )
                }
            }
        }
    }
}
package com.example.ailhadamutacao

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ailhadamutacao.componentes.ChoiceBox
import com.example.ailhadamutacao.componentes.DialogBox
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Cena(storyEvents: List<StoryEvent>) {
    val backgroundImage: Painter =
        painterResource(id = R.drawable.quarto)
    Box(
        Modifier
            .fillMaxHeight()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        val coroutineScope = rememberCoroutineScope()
        var currentEventIndex by remember { mutableIntStateOf(0) }
        var visibility by remember {
            mutableStateOf(true)
        }

        fun nextEvent() {
            if (currentEventIndex < storyEvents.size - 1) {
                visibility = true
                currentEventIndex++
            }
        }

        val density = LocalDensity.current

        // Conteúdo animado dentro do Box principal
        Box(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = visibility,
                enter = slideInHorizontally {
                    with(density) { -40.dp.roundToPx() }
                } + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    initialAlpha = 0.3f
                ),
                exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()
            ) {
                when (val event = storyEvents[currentEventIndex]) {
                    is StoryEvent.Dialogue -> {
                        DialogBox(
                            nome = event.character,
                            idImagem = event.imagem,
                            fala = event.text,
                            alinhar = event.alinhar,
                            onFimFala = {
                                visibility = false
                                coroutineScope.launch {
                                    delay(200)
                                    nextEvent()
                                }
                            }
                        )
                    }
                    is StoryEvent.Choice -> {
                        ChoiceBox(
                            modifier = Modifier.align(Alignment.BottomEnd),
                            escolhas = event.choices,
                            escolhido = {
                                visibility = false
                                coroutineScope.launch {
                                    delay(200)
                                    nextEvent()
                                }
                            },
                            idImagem = event.imagem,
                            alinhar = event.alinhar
                        )
                    }
                }
            }
        }
    }
}

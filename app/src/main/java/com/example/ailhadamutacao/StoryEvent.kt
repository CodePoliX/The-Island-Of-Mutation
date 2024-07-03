package com.example.ailhadamutacao

import androidx.compose.ui.Alignment

sealed class StoryEvent {
    data class Dialogue(val character: String, val text: String, val imagem: Int, val alinhar: Alignment) : StoryEvent()
    data class Choice(val choices: List<String>, val imagem: Int, val alinhar: Alignment) : StoryEvent()
}


package com.example.ailhadamutacao

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ailhadamutacao.componentes.DialogBox
//
//class Personagem(
//    var nome: String, val personagemImagem: List<Int>, var alinhar: Alignment
//) {
//    @Composable
//    fun Falar(modifier: Modifier, fala: String, index: Int, alinhar: Alignment){
//        DialogBox(nome = this.nome, idImagem = this.personagemImagem[index], fala = fala, alinhar = alinhar)
//    }
//    fun Escolher(){
//
//    }
//}

// Definição dos eventos
sealed class StoryEvent {
    data class Dialogue(val character: String, val text: String, val imagem: Int) : StoryEvent()
    data class Choice(val choices: List<String>, val imagem: Int, val alinhar: Alignment) : StoryEvent()
}


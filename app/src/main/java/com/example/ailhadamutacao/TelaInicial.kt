package com.example.ailhadamutacao

import android.health.connect.datatypes.Device
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun TelaInicial(){
    Box(Modifier
        .fillMaxSize()){
        val imagemDal = painterResource(id = R.drawable.dalila_sprite_confusa_foreground)
        Image(painter = imagemDal, contentDescription = "")
    }
}
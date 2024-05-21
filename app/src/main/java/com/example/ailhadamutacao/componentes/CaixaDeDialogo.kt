package com.example.ailhadamutacao.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.ailhadamutacao.R
import com.example.ailhadamutacao.ui.theme.Black35
import com.example.ailhadamutacao.ui.theme.Yellow40
import kotlinx.coroutines.launch

@Composable
fun DialogBox(nome: String, idImagem: Int, fala: String, alinhar: Alignment, onFimFala: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = "",
            modifier = Modifier.align(alinhar)
        )
        Column(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 20.dp)) {
            Card(
                Modifier
                    .padding(horizontal = 55.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Yellow40
                ),
                border = BorderStroke(1.dp, Color.Black),
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    text = nome, style = TextStyle(color = Color.White)
                )
            }
            Card(
                Modifier
                    .padding(horizontal = 50.dp, vertical = 2.dp)
                    .fillMaxWidth()
                    .clickable { onFimFala() },
                colors = CardDefaults.cardColors(
                    containerColor = Black35
                ),
                shape = RoundedCornerShape(25.dp),
                border = BorderStroke(1.dp, Color.Black),
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        fala,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier
                    )
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = "",
                        tint = Color.White,
                    )
                }
            }
        }
    }
}

//@Composable
//@Preview
//fun CaixaDeDialogoPreview(){
//    CaixaDeDialogo(modifier = Modifier)
//}
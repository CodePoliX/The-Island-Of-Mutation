package com.example.ailhadamutacao.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ailhadamutacao.ui.theme.Black35

@Composable
fun ChoiceBox(modifier: Modifier, escolhas: List<String>, escolhido: () -> Unit, idImagem: Int,alinhar:Alignment) {
    Box (Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = "",
            modifier = Modifier.align(alinhar)
        )
        Column(modifier.fillMaxWidth()) {
            LazyColumn {
                items(escolhas) { escolha ->
                    Card(
                        modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .clickable { escolhido()},
                        colors = CardDefaults.cardColors(containerColor = Black35),
                        border = BorderStroke(1.dp, Color.Black),
                    ) {
                        Text(
                            escolha,
                            modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(10.dp),
                            style = TextStyle(color = Color.White, fontWeight = FontWeight.W400)
                        )
                    }
                }
            }
        }
    }

}

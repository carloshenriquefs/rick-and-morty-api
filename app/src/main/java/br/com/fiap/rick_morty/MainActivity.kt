package br.com.fiap.rick_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.rick_morty.screens.CharacterListScreen
import br.com.fiap.rick_morty.ui.theme.RickmortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickmortyTheme {
                CharacterListScreen()
            }
        }
    }
}

package br.com.fiap.rick_morty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.rick_morty.R
import br.com.fiap.rick_morty.model.Character
import br.com.fiap.rick_morty.model.Result
import br.com.fiap.rick_morty.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CharacterListScreen(modifier: Modifier = Modifier) {

    var characterList by remember {
        mutableStateOf(listOf<Character>())
    }

    val callCharacter = RetrofitFactory()
        .getCharacterService()
        .getAllCharacters()

    callCharacter.enqueue(object : Callback<Result> {
        override fun onResponse(p0: Call<Result>, resultado: Response<Result>) {
            characterList = resultado.body()!!.results!!
        }

        override fun onFailure(p0: Call<Result>, p1: Throwable) {
        }

    })

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.char_list)
            )
            LazyColumn {
                items(characterList) { character ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    ) {
                        Row {
                            AsyncImage(
                                model = character.image,
                                contentDescription = ""
                            )

                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Nome: ${character.characterName}",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "Espécie: ${character.species}")
                                Text(text = "Gender: ${character.gender}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterListScreenPreview() {
    CharacterListScreen()
}

//1:52:40
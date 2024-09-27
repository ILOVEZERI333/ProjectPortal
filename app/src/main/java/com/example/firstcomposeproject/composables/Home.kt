package com.example.firstcomposeproject.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.firstcomposeproject.network.TweetGetInterceptor
import com.example.firstcomposeproject.network.fetchPokemonNews
import com.example.firstcomposeproject.network.pokemonNotification
import com.google.android.datatransport.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.Properties


@Composable
fun HomeScreen(bearer_token: String){

    val sharedListContent: SharedListContent = SharedListContent(mutableListOf())

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(135, 196, 193))) {
        HomeText()
        RowOptions(sharedListContent, bearer_token)
        ListOfItems(sharedListContent)
    }
}



@Composable
fun HomeText(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text("Hi, Tony!", fontSize = 35.sp, modifier = Modifier.padding(top = 50.dp))
    }

}


suspend fun ChangeListContents(listType: ListType, sharedListContent: SharedListContent, bearer_token:String){



    when (listType) {
        ListType.Manga -> TODO()
        ListType.Music -> TODO()
        ListType.Program -> TODO()
        ListType.Pokemon -> {
            sharedListContent.updateContent(fetchPokemonNews(bearer_token))
        }
    }
}

@Composable
fun RowOptions(sharedListContent: SharedListContent, bearer_token: String){

    var changingListContents by remember { mutableStateOf(false) }
    /* uncomment when implementing for other buttons
    var listToFetch by remember { mutableStateOf(ListType.Pokemon) }
    */

    LaunchedEffect(changingListContents) {
        if (changingListContents) {
            ChangeListContents(ListType.Pokemon, sharedListContent, bearer_token)
        }
    }



    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp, bottom = 20.dp)
        .background(color = Color(red = 178, green = 217, blue = 217))
        .height(100.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = { }, colors = ButtonDefaults.buttonColors(Color(red = 178, green = 217, blue = 217), Color.Black)) { Text("\uD83D\uDCD6\n" + "Manga")}
        Button(onClick = {  }, colors = ButtonDefaults.buttonColors(Color(red = 178, green = 217, blue = 217), Color.Black)) { Text("\uD83C\uDFA7\n" + "Music")}
        Button(onClick = { changingListContents= true; }, colors = ButtonDefaults.buttonColors(Color(red = 178, green = 217, blue = 217), Color.Black)) { Text("\uD83D\uDD34\n" + "Pokemon")}
        Button(onClick = { }, colors = ButtonDefaults.buttonColors(Color(red = 178, green = 217, blue = 217), Color.Black)) { Text("\uD83D\uDCBB\n" + "Program")}
    }
}

fun LoadMusicContent(){

}

@Composable
fun ListOfItems(sharedListContent: SharedListContent) {

    val content by sharedListContent.content

    var scrollState = rememberScrollState()


    /*
    use this to get pokemon news
     */
    var rows = remember { mutableStateListOf<pokemonNotification>() }

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {

        rows.forEach { row -> run {
            Row(
                modifier = Modifier
                    .padding(vertical = 14.dp, horizontal = 14.dp)
                    .background(
                        Color(148, 202, 204),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .height(100.dp)
                    .fillMaxWidth(0.95f)
            ) { Text("asd") }
        } }
    }

}

enum class ListType {
    Manga, Music, Pokemon, Program
}



class SharedListContent(val list: List<pokemonNotification>): ViewModel() {

    private var _content = mutableStateOf(list)
    val content: MutableState<List<pokemonNotification>> get() = _content

    fun updateContent(newList: List<pokemonNotification>){
        _content = mutableStateOf(newList)
    }

}
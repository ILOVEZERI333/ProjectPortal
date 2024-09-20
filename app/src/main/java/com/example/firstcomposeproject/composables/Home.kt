package com.example.firstcomposeproject.composables

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.firstcomposeproject.HomeScreen



@Composable
fun HomeScreen(){

    val sharedListContent: SharedListContent = SharedListContent(ListItem(Color.Cyan, "asd"))

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(135, 196, 193))) {
        HomeText()
        RowOptions(sharedListContent)
        ListOfItems(sharedListContent)
    }
}



@Composable
fun HomeText(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text("Hi, Tony!", fontSize = 35.sp, modifier = Modifier.padding(top = 50.dp))
    }
}


fun ChangeListContents(listType: ListType, sharedListContent: SharedListContent){
    when (listType) {
        ListType.Manga -> sharedListContent.updateData(Color(199, 166, 224))
        ListType.Music -> sharedListContent.updateData(Color(136, 207, 155))
        ListType.Program -> sharedListContent.updateData(Color(131, 185, 235))
        ListType.Pokemon -> sharedListContent.updateData(Color(237, 204, 183))
    }
}

@Composable
fun RowOptions(sharedListContent: SharedListContent){

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp, bottom = 20.dp)
        .background(color = Color(red = 178, green = 217, blue = 217))
        .height(100.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = { ChangeListContents(ListType.Manga, sharedListContent) }, colors = ButtonDefaults.buttonColors(Color(red = 178, green = 217, blue = 217), Color.Black)) { Text("\uD83D\uDCD6\n" + "Manga")}
        Button(onClick = { ChangeListContents(ListType.Music, sharedListContent) }, colors = ButtonDefaults.buttonColors(Color(red = 178, green = 217, blue = 217), Color.Black)) { Text("\uD83C\uDFA7\n" + "Music")}
        Button(onClick = { ChangeListContents(ListType.Pokemon, sharedListContent) }, colors = ButtonDefaults.buttonColors(Color(red = 178, green = 217, blue = 217), Color.Black)) { Text("\uD83D\uDD34\n" + "Pokemon")}
        Button(onClick = { ChangeListContents(ListType.Program, sharedListContent) }, colors = ButtonDefaults.buttonColors(Color(red = 178, green = 217, blue = 217), Color.Black)) { Text("\uD83D\uDCBB\n" + "Program")}
    }
}

fun LoadMusicContent(){

}

@Composable
fun ListOfItems(sharedListContent: SharedListContent) {

    val content by sharedListContent.content

    var scrollState = rememberScrollState()



    var rows = remember { mutableStateListOf<ListItem>() }

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {

        rows.forEach { row -> run {
            Row(
                modifier = Modifier.padding(vertical = 14.dp, horizontal = 14.dp).background(
                    sharedListContent.content.value.Color,
                    shape = RoundedCornerShape(5.dp)
                ).height(100.dp).fillMaxWidth(0.95f)
            ) { Text("asd") }
        } }
    }

}

enum class ListType {
    Manga, Music, Pokemon, Program
}

data class ListItem(val Color: Color, val content: String){

}

class SharedListContent(val listItem: ListItem): ViewModel() {

    private var _content = mutableStateOf(ListItem(Color(144, 212, 195), "asd") )
    val content: MutableState<ListItem> get() = _content

    fun updateData(newData: Color){
        _content.value = ListItem(newData, "asd")
    }


}
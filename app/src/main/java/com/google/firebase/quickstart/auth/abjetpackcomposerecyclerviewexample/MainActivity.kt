package com.google.firebase.quickstart.auth.abjetpackcomposerecyclerviewexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.quickstart.auth.abjetpackcomposerecyclerviewexample.compose.TvShowListItem
import com.google.firebase.quickstart.auth.abjetpackcomposerecyclerviewexample.data.TvShowList
import com.google.firebase.quickstart.auth.abjetpackcomposerecyclerviewexample.model.TvShow
import com.google.firebase.quickstart.auth.abjetpackcomposerecyclerviewexample.ui.theme.AbJetpackComposeRecyclerViewExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            DisplayTvShows {
                //Toast.makeText(this, it.name,Toast.LENGTH_LONG).show()
                startActivity(InfoActivity.intent(this,it))
            }
        }
    }
}
@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> Unit) {

    val tvShows = remember { TvShowList.tvShows }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp,vertical = 8.dp)
    ) {
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem)
            }
        )
    }

}




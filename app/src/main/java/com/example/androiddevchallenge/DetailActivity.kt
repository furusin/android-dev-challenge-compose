package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.Puppy

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                val puppy = intent.getSerializableExtra(KEY_PUPPY) as Puppy
                PuppyDetail(puppy = puppy)
            }
        }
    }

    companion object {
        const val KEY_PUPPY = "KEY_PUPPY"
        fun createIntent(context: Context, puppy: Puppy) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(KEY_PUPPY, puppy)
            }
    }
}


@Composable
fun PuppyDetail(puppy: Puppy) {
    Column(Modifier.fillMaxWidth()) {
        Column {
            val image = painterResource(id = puppy.imageResId)
            Image(painter = image, contentDescription = null)
            Text("name: ${puppy.name}")
            Text("age: ${puppy.age}")
        }
    }
}
/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.Puppy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                PuppyList(this)
            }
        }
    }
}

// Start building your app here!
@Composable
fun PuppyItem(context: Context, puppy: Puppy) {
    val image = painterResource(id = puppy.imageResId)

    Row(modifier = Modifier.clickable {
        context.startActivity(DetailActivity.createIntent(context, puppy))

    }) {
        Image(
            painter = image,
            contentDescription = null
        )
        Column {
            Text(text = "name: ${puppy.name}")
            Text(text = "age: ${puppy.age}")
        }
    }
}

@Composable
fun PuppyList(context: Context) {
    val puppy1 = Puppy(
        name = "Abbie",
        age = 2,
        imageResId = R.drawable.puppy1
    )

    val puppy2 = Puppy(
        name = "Bob",
        age = 3,
        imageResId = R.drawable.puppy2
    )

    val puppy3 = Puppy(
        name = "Oliver",
        age = 4,
        imageResId = R.drawable.puppy3
    )
    val puppyList = mutableListOf(puppy1, puppy2, puppy3)

    Box(modifier = Modifier) {
        Column(Modifier.fillMaxWidth()) {
            puppyList.forEach { puppy ->
                PuppyItem(context = context, puppy = puppy)
            }
        }
    }
}
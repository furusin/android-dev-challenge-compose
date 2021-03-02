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

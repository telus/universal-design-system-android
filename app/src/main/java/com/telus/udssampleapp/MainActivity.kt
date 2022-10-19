package com.telus.udssampleapp

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telus.udsnative.components.progressbar.ProgressBar
import com.telus.udsnative.components.progressbar.ProgressBarVariant
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val progress = MutableStateFlow(0f)

            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    "Progress Bar",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                ProgressBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .padding(horizontal = 16.dp),
                    progress = progress
                )

                ProgressBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .padding(horizontal = 16.dp),
                    progress = progress,
                    inactive = true
                )

                ProgressBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .padding(horizontal = 16.dp),
                    progress = progress,
                    variant = ProgressBarVariant(negative = true)
                )

                Row {
                    Button(
                        modifier = Modifier.padding(start = 16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                        onClick = {
                            if (progress.value < 1f) {
                                progress.value = progress.value + .1f
                            }
                        }
                    ) {
                        Text(text = "Test Progress", color = Color.White)
                    }

                    Button(
                        modifier = Modifier.padding(start = 16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                        onClick = {
                            progress.value = 0.0F
                        }
                    ) {
                        Text(text = "Reset", color = Color.White)
                    }
                }

                Column(
                    Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        "Button",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    com.telus.udsnative.components.button.Button(
                        text = "Default Button",
                        onClick = {}
                    )
                }
            }
        }
    }
}

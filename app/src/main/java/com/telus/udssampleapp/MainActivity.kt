package com.telus.udssampleapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.telus.udsnative.components.progressbar.ProgressBar
import com.telus.udsnative.components.progressbar.ProgressBarVariant
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val progress = MutableStateFlow(0f)

            Column(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = {
                        if (progress.value < 1f) {
                            progress.value = progress.value + .1f
                        }
                    }
                ) {
                    Text(text = "test progress")
                }

                ProgressBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    progress = progress
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProgressBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    progress = progress,
                    variant = ProgressBarVariant(inactive = true, negative = false)
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProgressBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    progress = progress,
                    variant = ProgressBarVariant(inactive = false, negative = true)
                )

            }
        }
    }
}
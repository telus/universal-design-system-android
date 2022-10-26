package com.telus.udssampleapp.scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telus.udsnative.components.progressbar.ProgressBar
import com.telus.udsnative.components.progressbar.ProgressBarVariant

class ProgressBarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
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

                        Spacer(modifier = Modifier.height(16.dp))

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
                }
            }
        }
    }
}
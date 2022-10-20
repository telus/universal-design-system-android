package com.telus.udssampleapp

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telus.udsnative.components.button.*
import com.telus.udsnative.components.progressbar.ProgressBar
import com.telus.udsnative.components.progressbar.ProgressBarVariant
import com.telus.udsnative.models.UDSColor
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val progress = MutableStateFlow(0f)

            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxSize()
                    .background(Color.Black),
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
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Button(
                        text = "Default Button",
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {}
                    )

                    Button(
                        text = "Danger Button",
                        modifier = Modifier.fillMaxWidth(),
                        variant = ButtonVariant(danger = true),
                        onClick = {}
                    )

                    Button(
                        text = "Inverse Button",
                        modifier = Modifier.fillMaxWidth(),
                        variant = ButtonVariant(inverse = true),
                        onClick = {}
                    )

                    Button(
                        text = "High Priority Inverse Button",
                        modifier = Modifier.fillMaxWidth(),
                        variant = ButtonVariant(priority = ButtonPriority.High, inverse = true),
                        onClick = {}
                    )

                    Button(
                        text = "High Priority Button",
                        modifier = Modifier.fillMaxWidth(),
                        variant = ButtonVariant(priority = ButtonPriority.High),
                        onClick = {}
                    )

                    Button(
                        text = "Low Priority Text Button",
                        modifier = Modifier.fillMaxWidth(),
                        variant = ButtonVariant(priority = ButtonPriority.Low, text = true),
                        onClick = {}
                    )

                    Button(
                        text = "High Priority Text Button",
                        modifier = Modifier.fillMaxWidth(),
                        variant = ButtonVariant(priority = ButtonPriority.High, text = true),
                        onClick = {}
                    )

                    Button(
                        text = "High Priority Text Button",
                        modifier = Modifier.fillMaxWidth(),
                        buttonTokens = buttonTokens,
                        onClick = {}
                    )
                }
            }
        }
    }
}

val buttonTokens = ButtonTokens(
    backgroundColor = UDSColor("#ffffff"),
    borderColor = UDSColor("#00ff00"),
    borderRadius = 32.dp,
    borderWidth = 1.dp,
    color = UDSColor("#000000"),
    fontName = "SF Pro",
    fontSize = 14.sp,
    icon = "example-icon",
    iconSize = 12,
    iconSpace = 12,
    iconPosition = IconPosition.Right,
    lineHeight = 1f,
    opacity = 1.dp,
    outerBackgroundColor = UDSColor("#00ffffff"),
    outerBorderColor = UDSColor("#00ff00"),
    outerBorderGap = 2.dp,
    outerBorderWidth = 2.dp,
    paddingBottom = 12.dp,
    paddingLeft = 32.dp,
    paddingRight = 32.dp,
    paddingTop = 12.dp,
    textAlign = TextAlignment("center")
//textLine= .underline,
//textLineStyle= .none
)

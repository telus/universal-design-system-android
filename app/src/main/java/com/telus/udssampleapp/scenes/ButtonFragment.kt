package com.telus.udssampleapp.scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.telus.udsnative.components.button.*
import com.telus.udsnative.models.UDSColor

class ButtonFragment : Fragment() {

    private val buttonTokens = ButtonTokens(
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
        shadow = null,
        textAlign = TextAlignment("center"),
        textLine= TextLine("none"),
        textLineStyle= "none"
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Box(modifier = Modifier
                    .background(Color.Black)
                    .fillMaxSize()){
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
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
                            text = "Custom Button",
                            modifier = Modifier.fillMaxWidth(),
                            buttonTokens = buttonTokens,
                            onClick = {}
                        )
                        Button(
                            text =  "Inactive Button",
                            modifier = Modifier.fillMaxWidth(),
                            variant = ButtonVariant(priority = ButtonPriority.High),
                            state = ButtonState.Inactive,
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}


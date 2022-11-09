package com.telus.udssampleapp.scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.telus.udsnative.components.typography.*
import com.telus.udsnative.models.UDSColor

class TypographyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Black)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 5.dp, bottom = 5.dp)
                                .fillMaxWidth(),
                            text = "All Typography Sizes",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Column(modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()) {

                        enumValues<TypographySize>().forEach {
                            Typography(
                                text = it.name,
                                variant = TypographyVariant(
                                    colour = TypographyColor.secondary,
                                    size = it
                                )
                            )
                        }
                    }


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Black)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 5.dp, bottom = 5.dp)
                                .fillMaxWidth(),
                            text = "Custom",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Typography(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "Bold Inverse Tertiary Large",
                            variant = TypographyVariant(
                                bold = true,
                                colour = TypographyColor.tertiary,
                                inverse = true,
                                size = TypographySize.large
                            )
                        )

                        Typography(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "Custom Tokens",
                            typographyTokens = TypographyTokens(
                                color = UDSColor(0f, 0f, 1f, 1f),
                                fontSize = 32,
                                fontScaleCap = 64,
                                fontWeight = 400,
                                letterSpacing = 8.0,
                                lineHeight = 32.0,
                                textTransform = TextTransform.uppercase,
                                fontName = TypographyFontName("Helvetica")
                            )
                        )
                    }



                }
            }
        }
    }
}
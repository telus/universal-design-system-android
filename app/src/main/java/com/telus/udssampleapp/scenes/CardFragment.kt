package com.telus.udssampleapp.scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.telus.udsnative.components.card.*
import com.telus.udsnative.components.card.models.CustomPadding
import com.telus.udsnative.components.card.models.Shadow
import com.telus.udsnative.models.UDSColor

class CardFragment : Fragment() {

    private val cardTokens = CardTokens(
        backgroundColor = UDSColor("#000000"),
        borderColor = UDSColor("#ff0000"),
        borderRadius = 16.dp,
        borderWidth = 1.dp,
        minWidth = 100.dp,
        paddingBottom = 16.dp,
        paddingLeft = 16.dp,
        paddingRight = 16.dp,
        paddingTop = 16.dp,
        shadow = Shadow(0.dp, UDSColor("#00ff00"), false, 0.dp, 0.dp, 0.dp)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),

                        ) {
                        Text(text = "Default Card")
                        Text(text = "Default Background - Default Padding")
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Card(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        variant = CardVariant(
                            background = Background.alternative,
                            padding = Padding.narrow
                        )
                    ) {
                        Text(text = "Alternative Card")
                        Text(text = "Alternative Background - Narrow Padding")
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Card(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        variant = CardVariant(padding = Padding.custom),
                        customInnerContentPadding = CustomPadding(
                            start = 25.dp,
                            top = 25.dp,
                            bottom = 25.dp
                        )
                    ) {
                        Text(text = "Custom Padding Card")
                        Text(text = "Default Background - Custom Padding")
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Card(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        cardTokens = cardTokens
                    ) {
                        Text(
                            text = "Custom Padding Card",
                            color = Color.White
                        )
                        Text(
                            text = "Default Background - Custom Padding",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}



package com.telus.udssampleapp.scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.telus.udssampleapp.R

class ComponentSelectorFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                ) {

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                        findNavController().navigate(R.id.viewProgressBar)
                    }) {
                        Text(text = "ProgressBar")
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                        findNavController().navigate(R.id.viewCard)
                    }) {
                        Text(text = "Card")
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            findNavController().navigate(R.id.viewButton)
                        }) {
                        Text(text = "Button")
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            findNavController().navigate(R.id.viewTypography)
                        }) {
                        Text(text = "typography")
                    }
                }
            }
        }
    }
}
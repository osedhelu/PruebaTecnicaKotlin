package com.osedhelu.creditbanco.ui.Layouts

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.osedhelu.creditbanco.ui.Screens.LoginScreen.LoginHelpers
import com.osedhelu.creditbanco.ui.Screens.LoginScreen.LoginScreen
import com.osedhelu.creditbanco.ui.components.Headers.MainHeader
import com.osedhelu.creditbanco.ui.components.Loading.Loading
import com.osedhelu.creditbanco.ui.components.Loading.LoadingHelper
import com.osedhelu.creditbanco.ui.components.Toast.ToastComponent
import com.osedhelu.creditbanco.ui.components.Toast.ToastDuration
import com.osedhelu.creditbanco.ui.theme.PurpleGrey40


@Composable
fun MainLayout(
    navController: NavController,
    bottomBar: @Composable () -> Unit = { Spacer(modifier = Modifier.size(0.dp)) },
    children: @Composable () -> Unit
) {
    val LottieisLoadding by remember {
        LoadingHelper.isLoading

    }
    val isLoggin by remember {
        LoginHelpers.isLogin
    }
    if (LottieisLoadding) {
        Loading()
    }
    ToastComponent(
        ToastDuration.Long
    )

    if (isLoggin) {
        Scaffold(topBar = {
            MainHeader(navController = navController)
        }, bottomBar = { bottomBar() }, containerColor = PurpleGrey40) {
            Box() {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    contentAlignment = Alignment.TopCenter,

                    ) {
                    Canvas(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val boxSize = size
                        val borderF = 45f
                        val cornerRadius = CornerRadius(borderF, borderF)
                        val path = Path().apply {
                            addRoundRect(
                                RoundRect(
                                    rect = Rect(
                                        offset = Offset(0f, 0f),
                                        size = boxSize, //usar el tamaño de la caja
                                    ), topLeft = cornerRadius, topRight = cornerRadius
                                )
                            )
                        }
                        drawPath(path, color = Color.White)
                    }

                    // Aquí puedes poner tus hijos
                    children()
                }


            }


        }
    } else {
        LoginScreen()
    }

}


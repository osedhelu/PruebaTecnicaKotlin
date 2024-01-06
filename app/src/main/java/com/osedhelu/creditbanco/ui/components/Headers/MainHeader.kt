package com.osedhelu.creditbanco.ui.components.Headers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.osedhelu.creditbanco.R
import com.osedhelu.creditbanco.ui.Screens.LoginScreen.LoginHelpers
import com.osedhelu.creditbanco.utils.GoToActivity
import com.osedhelu.creditbanco.utils.getDatetime
import com.osedhelu.creditbanco.utils.iNameActivity


@Composable
fun MainHeader(navController: NavController) {
    val context = LocalContext.current
    val date = getDatetime()
    val btnVolver by remember {
        HeaderHelper.btnVolver
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp)
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (btnVolver) {
                IconButton(onClick = {
                    navController.navigate("main")
                    HeaderHelper.reset()
                }, modifier = Modifier.size(30.dp, 30.dp)) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = Color.Blue,
                        contentDescription = "Setting"
                    )
                }

            } else {
                Spacer(
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.logo_company),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.size(height = 60.dp, width = 180.dp)
            )
            if (true) {
                IconButton(onClick = {
                    LoginHelpers.reset()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        tint = Color.Blue,
                        contentDescription = "Setting"
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(30.dp, 30.dp))
            }

        }
        if (!btnVolver) {
            Text(
                text = stringResource(id = R.string.TEXT_BIENVENIDO),
                color = Color.Black,
                modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = "${date.week} ${date.dd} de ${date.LLLL} ${date.yyyy} ${date.hora}")
        }
    }

}

package com.osedhelu.creditbanco.ui.Screens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.osedhelu.creditbanco.R
import com.osedhelu.creditbanco.ui.Screens.ReportScreen.ReportHelper
import com.osedhelu.creditbanco.ui.Screens.anularPago.AnnulmentHelpers
import com.osedhelu.creditbanco.ui.Screens.pagoScreen.pagoHelper
import com.osedhelu.creditbanco.ui.components.Headers.HeaderHelper
import com.osedhelu.creditbanco.ui.theme.Purple40


data class iCardButton(val title: String, val icon: Int, val path: String)

@Composable
fun MainScreen(navController: NavController) {
    val itemsList: List<iCardButton> = listOf(
        iCardButton("Pago", R.drawable.icon_payment, "pago"),
        iCardButton("Anular Pago", R.drawable.icons_cancel, "anularPago"),
        iCardButton("Reportes", R.drawable.icon_report, "resports"),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
    ) {
        items(itemsList) { item ->
            Button(
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple40
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp
                ),
                onClick = {
                    navController.navigate(item.path)
                    pagoHelper.reset()
                    AnnulmentHelpers.reset()
                    ReportHelper.reset()
                    HeaderHelper.show()
                }) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "",
                        tint = Color.White
                    )
                    Text(item.title)
                }

            }


        }
    }
}
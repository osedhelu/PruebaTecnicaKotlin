package com.osedhelu.creditbanco.ui.Screens.pagoScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.osedhelu.creditbanco.config.CommerceLocalData
import com.osedhelu.creditbanco.data.remote.apiBanco.ApiBancoViewModel
import com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs.AnnulmentTab02
import com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs.AnnulmentTab03
import com.osedhelu.creditbanco.ui.Screens.pagoScreen.tabs.PagoTab01
import com.osedhelu.creditbanco.ui.Screens.pagoScreen.tabs.PagoTab02
import com.osedhelu.creditbanco.ui.Screens.pagoScreen.tabs.PagoTab03
import com.osedhelu.creditbanco.ui.components.Headers.HeaderHelper
import com.osedhelu.creditbanco.ui.components.Loading.LoadingHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun PagoScreen(navController: NavController, viewModel: ApiBancoViewModel = hiltViewModel()) {
    var numTab by remember {
        pagoHelper.numTab
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    val ctx = LocalContext.current
    val commerce = CommerceLocalData.getCommerce(ctx)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (numTab) {
            0 -> PagoTab01()
            1 -> PagoTab02()
            2 -> PagoTab03() {
                HeaderHelper.reset()
                navController.popBackStack()
            }

            3 -> AnnulmentTab02(
                onClick = {
                    viewModel.AnnulmentPayment("${commerce?.token}") {
                        lifecycleOwner.lifecycleScope.launch {
                            withContext(Dispatchers.Main) {
                                LoadingHelper.ResetParams()
                                pagoHelper.nextTabs()
                            }
                        }
                    }
                }
            )

            4 -> AnnulmentTab03() {
                HeaderHelper.reset()
                navController.popBackStack()
            }
        }

    }
}

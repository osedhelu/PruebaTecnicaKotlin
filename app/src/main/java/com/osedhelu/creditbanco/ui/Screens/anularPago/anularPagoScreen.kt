package com.osedhelu.creditbanco.ui.Screens.anularPago

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs.AnnulmentTab01
import com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs.AnnulmentTab02
import com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs.AnnulmentTab03
import com.osedhelu.creditbanco.ui.Screens.pagoScreen.pagoHelper
import com.osedhelu.creditbanco.ui.components.Headers.HeaderHelper
import com.osedhelu.creditbanco.ui.components.Loading.LoadingHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun AnularPagoScreen(navController: NavController, viewModel: ApiBancoViewModel = hiltViewModel()) {
    val numTab by remember {
        AnnulmentHelpers.numTab
    }
    val lifecycleOwner = LocalLifecycleOwner.current

    val token = CommerceLocalData.getCommerce(LocalContext.current)?.token
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (numTab) {
            0 -> AnnulmentTab01()
            1 -> AnnulmentTab02(onClick = {
                viewModel.AnnulmentPayment("${token}") {
                    lifecycleOwner.lifecycleScope.launch {
                        withContext(Dispatchers.Main) {
                            AnnulmentHelpers.nextTabs()
                            LoadingHelper.ResetParams()
                        }
                    }
                }
            })

            2 -> AnnulmentTab03() {
                HeaderHelper.reset()
                navController.popBackStack()
            }
        }
    }
}



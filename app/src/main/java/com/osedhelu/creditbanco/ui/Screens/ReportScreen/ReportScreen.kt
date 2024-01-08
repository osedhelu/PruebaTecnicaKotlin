package com.osedhelu.creditbanco.ui.Screens.MainScreen

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
import com.osedhelu.creditbanco.data.remote.dto.AnnulmentDto
import com.osedhelu.creditbanco.ui.Screens.ReportScreen.ReportHelper
import com.osedhelu.creditbanco.ui.Screens.ReportScreen.tabs.tab01
import com.osedhelu.creditbanco.ui.Screens.anularPago.AnnulmentHelpers
import com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs.AnnulmentTab02
import com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs.AnnulmentTab03
import com.osedhelu.creditbanco.ui.components.Headers.HeaderHelper
import com.osedhelu.creditbanco.ui.components.Loading.LoadingHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun ReportScreen(navController: NavController, viewModel: ApiBancoViewModel = hiltViewModel()) {
    var numTab by remember {
        ReportHelper.numTab
    }
    val ctx = LocalContext.current
    val commerce = CommerceLocalData.getCommerce(ctx)
    val lifecycleOwner = LocalLifecycleOwner.current
    when (numTab) {
        0 -> tab01() {
            AnnulmentHelpers.form.value = AnnulmentDto(it.receiptId, it.rrn)
            ReportHelper.nextTabs()
        }

        1 -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnnulmentTab02(
                    onClick = {
                        viewModel.AnnulmentPayment("${commerce?.token}") {
                            lifecycleOwner.lifecycleScope.launch {
                                withContext(Dispatchers.Main) {
                                    LoadingHelper.ResetParams()
                                    numTab += 1
                                }
                            }
                        }
                    }
                )
            }
        }

        2 -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnnulmentTab03 {
                    HeaderHelper.reset()
                    navController.popBackStack()

                }
            }
        }
    }

}

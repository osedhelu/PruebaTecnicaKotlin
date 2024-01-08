package com.osedhelu.creditbanco.ui.Screens.ReportScreen.tabs


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.osedhelu.creditbanco.R
import com.osedhelu.creditbanco.data.local.database.Transaction
import com.osedhelu.creditbanco.data.remote.apiBanco.ApiBancoViewModel
import com.osedhelu.creditbanco.ui.components.RowItems
import com.osedhelu.creditbanco.utils.FormatePriceUtils
import com.osedhelu.creditbanco.utils.redidText


@Composable
fun tab01(viewModel: ApiBancoViewModel = hiltViewModel(), onClick: (Transaction) -> Unit) {
    val allTransaction by viewModel.AllTransaccions.observeAsState()


    LazyColumn(
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(
            start = 12.dp, top = 16.dp, end = 12.dp, bottom = 16.dp
        ),
    ) {
        allTransaction?.let {
            items(it.size) { item ->

                Card(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clickable {
                            if (it[item].ok) {
                                onClick(it[item])
                            }
                        }) {
                    Column(Modifier.padding(4.dp)) {
                        RowItems(
                            title = R.string.credit_card,
                            value = redidText(it[item].card)
                        )
                        RowItems(
                            title = R.string.num_resibo,
                            value = redidText(it[item].receiptId)
                        )
                        RowItems(
                            title = R.string.num_transaction,
                            value = redidText(it[item].rrn)
                        )
                        RowItems(title = R.string.fecha, value = it[item].fecha)
                        RowItems(
                            title = R.string.paymendetails,
                            value = it[item].statusDescription
                        )
                        RowItems(
                            title = R.string.monto,
                            value = FormatePriceUtils(it[item].amount)
                        )

                        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

                            Icon(
                                painter = painterResource(
                                    id = if (it[item].ok) {
                                        R.drawable.icon_success
                                    } else {
                                        R.drawable.icon_error
                                    }
                                ), contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(height = 30.dp, width = 30.dp)
                            )


                        }
                    }
                }
                Spacer(modifier = Modifier.height(3.dp)) // Añade un espacio de 16dp entre los elementos
            }
        }
    }

}
package com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.osedhelu.creditbanco.R
import com.osedhelu.creditbanco.ui.Screens.anularPago.AnnulmentHelpers
import com.osedhelu.creditbanco.ui.components.ButtonPersonal
import com.osedhelu.creditbanco.ui.components.InputGlobal
import com.osedhelu.creditbanco.utils.CreditCardVisualTransformation

@Composable
fun AnnulmentTab01() {
    var form by remember {
        AnnulmentHelpers.form
    }
    Spacer(modifier = Modifier.size(8.dp))
    Text(
        text = stringResource(id = R.string.anular_pago),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

    InputGlobal(
        title = stringResource(id = R.string.num_transaction),
        value = form.rrn,
        onChange = {
            form = form.copy(rrn = it)
        },
    )
    InputGlobal(
        title = stringResource(id = R.string.num_resibo),
        value = form.receiptId,
        onChange = {
            form = form.copy(receiptId = it)
        },
    )
    Spacer(modifier = Modifier.size(10.dp))
    ButtonPersonal(
        title = "Continuar",
        onClick = { AnnulmentHelpers.nextTabs() },
//        enabled = form.amount.isNotEmpty() && form.card.length == 16
    )
}
package com.osedhelu.creditbanco.ui.Screens.anularPago.Tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.osedhelu.creditbanco.R
import com.osedhelu.creditbanco.config.CommerceLocalData
import com.osedhelu.creditbanco.data.remote.apiBanco.ApiBancoViewModel
import com.osedhelu.creditbanco.ui.Screens.anularPago.AnnulmentHelpers
import com.osedhelu.creditbanco.ui.components.ButtonPersonal
import com.osedhelu.creditbanco.ui.components.RowItems
import com.osedhelu.creditbanco.utils.redidText

@Composable
fun AnnulmentTab02(onClick: () -> Unit, viewModel: ApiBancoViewModel = hiltViewModel()) {
    val form by remember {
        AnnulmentHelpers.form
    }
    val ctx = LocalContext.current
    val commerce = CommerceLocalData.getCommerce(ctx)
    Text(
        text = stringResource(id = R.string.title_annulment),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.size(33.dp))
    Box(
        modifier = Modifier
            .shadow(
                elevation = 8.dp, spotColor = Color(0xB906A4B4), ambientColor = Color(0xBE06A4B4)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 10.dp))
    ) {

        Column(
            Modifier
                .padding(10.dp), verticalArrangement = Arrangement.spacedBy(
                space = 13.dp, // espacio entre los elementos
                alignment = Alignment.Top
            )
        ) {


//      _____________________________________________________________________________________________
            RowItems(R.string.num_transaction, redidText(form.rrn))
            RowItems(R.string.num_resibo, redidText(form.receiptId))
//      _____________________________________________________________________________________________
//            RowItems(R.string.code_commerce, redidText("${commerce?.commerceCode}"))
//      _____________________________________________________________________________________________
//            RowItems(R.string.code_terminal, redidText("${commerce?.terminalCode}"))


            ButtonPersonal(title = "Confirmar", onClick = onClick)
        }
    }
}

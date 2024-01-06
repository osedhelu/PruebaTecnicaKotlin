package com.osedhelu.creditbanco.ui.Screens.pagoScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.osedhelu.creditbanco.R
import com.osedhelu.creditbanco.ui.components.ButtonPersonal
import com.osedhelu.creditbanco.ui.components.InputGlobal
import com.osedhelu.creditbanco.utils.CreditCardVisualTransformation
import com.osedhelu.creditbanco.utils.CurrencyAmountInputVisualTransformation
import com.osedhelu.creditbanco.utils.validarNumCreditCard
import com.osedhelu.creditbanco.utils.validarNumeroPrice
import com.osedhelu.creditbanco.utils.validarNumeroTarjetaCredito


@Composable
fun PagoScreen(navController: NavController) {
    var form by remember {
        pagoHelper.form
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = stringResource(id = R.string.pago),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        InputGlobal(
            title = "Número de la tarjeta",
            value = form.card,
            isError = validarNumeroTarjetaCredito(form.card),
            messageError = "Debes escribir un numero de tarjeta valido",
            onChange = {
                if (validarNumCreditCard(it)) {
                    form = form.copy(card = it.trimStart('0'))
                }
            },
            visualTransformation = CreditCardVisualTransformation()
        )
        InputGlobal(
            title = stringResource(id = R.string.monto),
            value = form.amount,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            trailingIcon = {
                Text(
                    text = "|   COP.", modifier = Modifier.padding(end = 15.dp), color = Color.Gray
                )

            },
            isError = try {
                (form.amount.toInt()) <= 0.001
            } catch (e: Exception) {
                true

            },
            messageError = "Debes escribir un monto mayor a 0",
            onChange = {
                if (validarNumeroPrice(it)) {
                    form = form.copy(amount = it.trimStart('0'))
                }
            },
            visualTransformation = CurrencyAmountInputVisualTransformation()
        )

        Spacer(modifier = Modifier.size(10.dp))
        ButtonPersonal(
            title = "Enviar",
            onClick = { println(form) },
            enabled = form.amount.isNotEmpty() && form.card.length == 16
        )
    }

}

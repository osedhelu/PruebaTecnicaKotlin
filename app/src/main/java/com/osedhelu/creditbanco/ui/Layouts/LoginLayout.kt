package com.osedhelu.creditbanco.ui.Layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.osedhelu.creditbanco.R
import com.osedhelu.creditbanco.config.CommerceLocalData
import com.osedhelu.creditbanco.utils.GoToActivity
import com.osedhelu.creditbanco.utils.iNameActivity


@Composable
fun LoginLayout(children: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        val ctx = LocalContext.current
        val commerce = CommerceLocalData.getCommerce(ctx)


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Spacer(modifier = Modifier.size(30.dp))
            Icon(
                painter = painterResource(id = R.drawable.logo_company),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.size(height = 60.dp, width = 180.dp)

            )
            if (commerce == null) {
                Spacer(modifier = Modifier.size(30.dp))
            } else {
                IconButton(onClick = {
                    CommerceLocalData.setCommerce(ctx, CommerceLocalData(0, "", ""))
                    GoToActivity(iNameActivity.MAIN, ctx)
                }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "")

                }
            }

        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Column(
                modifier = Modifier.padding(vertical = 30.dp, horizontal = 20.dp),
//                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                children()

            }
        }
    }

}
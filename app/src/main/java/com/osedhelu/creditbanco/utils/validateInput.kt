package com.osedhelu.creditbanco.utils


fun cumpleExpresion(cadena: String): Boolean {
    val aa = cadena.trimStart('0')
    val expresionRegular = "^(?!0)[0-9]{0,9}$".toRegex()
    return expresionRegular.matches(aa)
}


fun validarNumeroTelefono(cadena: String): Boolean {
    val aa = cadena.trimStart('0')
    val expresionRegular = "^(?!0)[0-9]{0,7}$".toRegex()
    return expresionRegular.matches(aa)
}

fun validarNumeroPrice(cadena: String): Boolean {
    val aa = cadena.trimStart('0')
    val expresionRegular = "^(?!0)[0-9]{0,7}$".toRegex()
    return expresionRegular.matches(aa)
}

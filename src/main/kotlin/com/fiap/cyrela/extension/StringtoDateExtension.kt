package com.fiap.cyrela.extension

import java.text.SimpleDateFormat
import java.util.Date

fun String.toDate(): Date =
    SimpleDateFormat("dd/MM/yyyy HH:mm").parse(this)


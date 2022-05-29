package com.miharu.planetphoto.core.extension

import org.threeten.bp.*
import org.threeten.bp.format.DateTimeFormatter

fun LocalDate.formatDefaultPattern(): String {
    return this.format(DateTimeFormatter.ofPattern(DATE_PATTERN))
}

fun LocalDate.toEpochMills(): Long {
    return this.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000L
}

fun Long.toLocalDate() : LocalDate {
    return Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault()).toLocalDate()
}

const val DATE_PATTERN = "yyyy-MM-dd"
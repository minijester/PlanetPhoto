package com.miharu.planetphoto.core.extension

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

fun String.formatDateString(oldFormat: String, newFormat: String) {
    LocalDate.parse(this, DateTimeFormatter.ofPattern(oldFormat))
        .format(DateTimeFormatter.ofPattern(newFormat))
}


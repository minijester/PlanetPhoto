package com.miharu.planetphoto.core.extension

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

fun LocalDate.formatDefaultPattern(): String {
    return this.format(DateTimeFormatter.ofPattern(DATE_PATTERN))
}

const val DATE_PATTERN = "yyyy-MM-dd"
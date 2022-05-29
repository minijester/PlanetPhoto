package com.miharu.planetphoto.core.util

import com.google.android.material.datepicker.CalendarConstraints
import kotlinx.parcelize.Parcelize

@Parcelize
class RangeValidator(private val minDate: Long, private val maxDate: Long) :
    CalendarConstraints.DateValidator {
    override fun isValid(date: Long): Boolean = date in minDate..maxDate
}
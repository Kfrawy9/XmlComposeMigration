package com.kfrawy.xmlcomposemigration

import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(date: Long): String{
    val date = Date(date)
    val formattedDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(date)
    return formattedDate
}

fun loadDatePicker(): MaterialDatePicker<Long>{
    val picker = MaterialDatePicker.Builder.datePicker()
        .setNegativeButtonText("Cancel")
        .setPositiveButtonText("Ok")
        .setTitleText("Select date")
        .build()
    return picker
}
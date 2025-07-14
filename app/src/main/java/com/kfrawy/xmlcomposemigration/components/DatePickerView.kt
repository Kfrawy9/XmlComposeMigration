package com.kfrawy.xmlcomposemigration.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kfrawy.xmlcomposemigration.active_stroke
import com.kfrawy.xmlcomposemigration.inactive_stroke
import com.kfrawy.xmlcomposemigration.pink_200

@Composable
fun DatePickerView(date: String = "",
               onTimeSelected: (Long) -> Unit = {}) {
    var showDatePicker by remember { mutableStateOf(false) }
    TextField(value = date, onValueChange = {},
        colors = TextFieldDefaults.colors(
            focusedContainerColor = pink_200,
            unfocusedContainerColor = pink_200,
            unfocusedIndicatorColor = inactive_stroke,
            focusedIndicatorColor = active_stroke,
            disabledContainerColor = pink_200,
            disabledTextColor = Color.Black
        ),textStyle = TextStyle.Default.copy(fontSize = 20.sp,
            textAlign = TextAlign.Justify,), enabled = false,
        modifier = Modifier
            .clickable(onClick = {
                showDatePicker = true
            }).fillMaxWidth().wrapContentHeight(), )

    if (showDatePicker)
        DatePickerDialog(onDismiss = {showDatePicker = false},
            onTimeSelected = {onTimeSelected(it)
            showDatePicker = false})

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DatePickerDialog(onDismiss: () -> Unit, onTimeSelected: (Long) -> Unit){
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(onDismissRequest = onDismiss, confirmButton = {
        TextButton(onClick = {
            onTimeSelected(datePickerState.selectedDateMillis!!)
        }) {
            Text("OK")
        }
    }, dismissButton = {
        TextButton(onClick = onDismiss) {
            Text("Cancel")
        }
    } ) {
        DatePicker(datePickerState)
    }
}
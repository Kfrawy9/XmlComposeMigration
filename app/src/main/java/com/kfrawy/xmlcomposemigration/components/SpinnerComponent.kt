package com.kfrawy.xmlcomposemigration.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kfrawy.xmlcomposemigration.active_stroke
import com.kfrawy.xmlcomposemigration.inactive_stroke
import com.kfrawy.xmlcomposemigration.pink_200

@Composable
fun SpinnerComponent(recurrence: String = "",
                     onValueChange: (String) -> Unit = {}) {
    var isEnabled by remember { mutableStateOf(false) }

    TextField(value = recurrence, onValueChange = {},
        colors = TextFieldDefaults.colors(
            focusedContainerColor = pink_200,
            unfocusedContainerColor = pink_200,
            unfocusedIndicatorColor = inactive_stroke,
            focusedIndicatorColor = active_stroke,
            disabledContainerColor = pink_200,
            disabledTextColor = Color.Black
        ),textStyle = TextStyle.Default.copy(fontSize = 18.sp,
            textAlign = TextAlign.Justify), enabled = false,
        trailingIcon = {
            Icon(imageVector =
                Icons.Default.ArrowDropDown, contentDescription = "Arrow Down",
                tint = Color.Black
            )
        }, modifier = Modifier.clickable(onClick = {
            isEnabled = !isEnabled
        }).size(width = 200.dp, height = 60.dp), )
    DropDowVie(isEnabled = isEnabled, {
        onValueChange(it)
        isEnabled = false
                                      }, {
        isEnabled = false
    })

}

@Composable
fun DropDowVie(isEnabled: Boolean, onClicked: (String) -> Unit, onDismiss: ()-> Unit) {
    DropdownMenu(isEnabled, onDismissRequest = onDismiss,
        modifier = Modifier.width(200.dp)) {
        spinner_items.forEach { item ->
            DropdownMenuItem(text = {Text(item, fontSize = 16.sp)},
                onClick = { onClicked(item) })
        }
    }
}

val spinner_items = listOf("Daily", "Weekly", "Monthly")
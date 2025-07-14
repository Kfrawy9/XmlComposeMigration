package com.kfrawy.xmlcomposemigration.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.chip.ChipGroup
import com.kfrawy.xmlcomposemigration.R
import com.kfrawy.xmlcomposemigration.active_stroke
import com.kfrawy.xmlcomposemigration.inactive_stroke
import com.kfrawy.xmlcomposemigration.pink_200


@Composable
fun InputField(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    TextField(value = value, onValueChange = onValueChange,
        modifier = modifier,
        keyboardOptions =
            KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = pink_200,
            unfocusedContainerColor = pink_200,
            unfocusedIndicatorColor = inactive_stroke,
            focusedIndicatorColor = active_stroke,
        ),textStyle = TextStyle.Default.copy(fontSize = 20.sp,
                textAlign = TextAlign.Justify),
        maxLines = 1)
}
@Composable
fun TitleText(text: String, modifier: Modifier){

    Text(text,
        fontSize = 14.sp,
        modifier = modifier)

}

@Composable
fun ChipGroup(selectedItems: List<Int> = emptyList(),
              onClicked: (Int) -> Unit = {}) {

    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(timesList.size){
                val selectedItem = selectedItems.contains(it)
                FilterChip(selected = selectedItem,
                    onClick = { onClicked(it) },
                    label = {
                        Text(timesList[it])
                    }, leadingIcon = {
                        Icon(painter = painterResource(R.drawable.check),
                            contentDescription = "Check")
                    })
            }
        }


    }

}

val timesList = listOf("Morning", "Afternoon", "Evening", "Night")




@Preview(showSystemUi = true)
@Composable
fun Preview(){
    ChipGroup()
}
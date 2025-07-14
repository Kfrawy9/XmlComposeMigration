package com.kfrawy.xmlcomposemigration

import android.icu.text.CaseMap
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kfrawy.xmlcomposemigration.components.ChipGroup
import com.kfrawy.xmlcomposemigration.components.DatePickerView
import com.kfrawy.xmlcomposemigration.components.InputField
import com.kfrawy.xmlcomposemigration.components.SpinnerComponent
import com.kfrawy.xmlcomposemigration.components.TitleText

@Composable
fun AddMedScreen() {

    val context = LocalContext.current

    var medName by remember { mutableStateOf("") }
    var dosage by remember { mutableStateOf("") }
    var recurrence by remember { mutableStateOf("") }
    var date by remember { mutableStateOf<Long>(0) }
    var selectedItems by remember { mutableStateOf(listOf<Int>()) }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(10.dp)) {
        Spacer(modifier = Modifier.padding(15.dp))
        Text("Add Medication",
            fontSize = 35.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.padding(15.dp))

        TitleText("Medication Name", Modifier)
        InputField(medName, {
            medName = it
        },
            Modifier.fillMaxWidth().wrapContentHeight(),)

        Row(horizontalArrangement = Arrangement.spacedBy(15.dp)){

            Column(modifier = Modifier.fillMaxWidth().weight(0.4f),
                verticalArrangement = Arrangement.spacedBy(4.dp)) {

                TitleText("Dosage", Modifier)
                InputField(value = dosage, onValueChange = {
                    dosage = it
                },
                    modifier = Modifier, keyboardType = KeyboardType.Decimal)
            }

            Column(modifier = Modifier.fillMaxWidth().weight(0.6f),
                verticalArrangement = Arrangement.spacedBy(4.dp)) {

                TitleText("Recurrence", Modifier)
                SpinnerComponent (recurrence){
                    recurrence = it
                }
            }

        }

        TitleText("End Date", Modifier)
        DatePickerView(formatDate(date)) {
            date = it
        }

        TitleText("Times of Day", Modifier)
        ChipGroup(selectedItems = selectedItems){ item ->
            val list = selectedItems.toMutableList()
            if (selectedItems.contains(item)){
                list.remove(item)
            }else{
                list.add(item)
            }

            selectedItems = list
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.fillMaxWidth()
            .align(Alignment.CenterHorizontally),) {
            Text("Save", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewScreen(){
    AddMedScreen()
}
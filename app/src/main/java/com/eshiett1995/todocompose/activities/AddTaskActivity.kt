package com.eshiett1995.todocompose.activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.Dimension.DP
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eshiett1995.todocompose.R
import com.eshiett1995.todocompose.viewModels.AddTaskViewModel


class AddTaskActivity : AppCompatActivity() {

    private var poppinsRegularFont = Font(resId = R.font.poppins_regular)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val addTaskViewModel : AddTaskViewModel by viewModels()
        setContent {
            val title : State<String> = addTaskViewModel.title.observeAsState("")
            val detail : State<String> = addTaskViewModel.detail.observeAsState("")

            val textFieldShape = RoundedCornerShape(5.dp)

            val textFieldColors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
            Column (modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {

                Text("Add a task",
                    color = Color.Blue,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(poppinsRegularFont),
                )
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = title.value,
                    onValueChange = {
                        addTaskViewModel.changeTitle(it)
                    },
                    shape = textFieldShape,
                    colors = textFieldColors,
                    label = { Text("Add a title",) }
                )
                Spacer(modifier = Modifier.height(25.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    value = detail.value,
                    onValueChange = {
                        addTaskViewModel.changeDetail(it)
                    },
                    shape = textFieldShape,
                    colors = textFieldColors
                )
                Spacer(modifier = Modifier.height(25.dp))
                Button(
                    onClick = {
                        addTaskViewModel.saveTask()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = Dp(0f)
                    )
                ) {
                    Text(
                        text = "Save task",
                        fontFamily = FontFamily(poppinsRegularFont)
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun CustomEditText(){
        TextField(value = "Bassey", onValueChange = { })
    }
}
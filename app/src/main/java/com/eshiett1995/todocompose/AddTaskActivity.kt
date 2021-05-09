package com.eshiett1995.todocompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.Dimension.DP
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                TextField(value = "Bassey", onValueChange = { })
                Spacer(modifier = Modifier.height(10.dp))
                TextField(value = "Bassey", onValueChange = { })
                Spacer(modifier = Modifier.height(10.dp))
                TextField(value = "Bassey", onValueChange = { })
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = Dp(0f)
                    )
                ) {
                    Text(text = "Save task")
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
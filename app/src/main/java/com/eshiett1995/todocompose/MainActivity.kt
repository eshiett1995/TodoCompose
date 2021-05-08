package com.eshiett1995.todocompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {

    private var poppinsRegularFont = Font(resId = R.font.poppins_regular)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            Intent(this, AddTaskActivity::class.java).run {
                                startActivity(this)
                            }
                        },
                        backgroundColor = Color.Blue,
                        contentColor = Color.White
                    ){
                        Icon(Icons.Rounded.Add,"" )
                    }
                }
            ) {
                Surface(
                    color = Color(105,124,201,),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Column (modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                        Text(
                            "Hello",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontFamily = FontFamily(poppinsRegularFont)
                        )
                        Text("Thursday, February 6", color = Color.White)
                        Spacer(modifier = Modifier.height(30.dp))
                        TaskCard()
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun TaskCard(){
      Card (
          backgroundColor = Color.White,
      ){
         Row (
             verticalAlignment = Alignment.CenterVertically,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(horizontal = 5.dp, vertical = 15.dp)
         ){
             CustomCheckBox()
             Spacer(modifier = Modifier.width(10.dp))
             Column {
                 Text("screen shot for Todo App")
                 Row{
                     Text("Tasks.")
                     Text("Friday, Feb 7, 9:00AM")
                 }
             }
         }
      }
    }

    @Preview
    @Composable
    fun CustomCheckBox() {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(30.dp)
                .background(Color.Black)
                .padding(1.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}
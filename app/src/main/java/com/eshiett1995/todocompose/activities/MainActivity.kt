package com.eshiett1995.todocompose.activities

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eshiett1995.todocompose.R
import com.eshiett1995.todocompose.data.entity.Task
import com.eshiett1995.todocompose.viewModels.AddTaskViewModel
import com.eshiett1995.todocompose.viewModels.ViewTasksViewModel

class MainActivity : AppCompatActivity() {

    private var poppinsRegularFont = Font(resId = R.font.poppins_regular)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewTasksViewModel : ViewTasksViewModel by viewModels()

        setContent{
            val tasks = viewTasksViewModel.tasks.observeAsState()
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
                        if (tasks.value != null){
                            if(tasks.value!!.isNotEmpty()){
                                tasks.value!!.forEach { task ->
                                    TaskCard(task)
                                }
                            }else{
                                Box(
                                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.ic_safebox),
                                        contentDescription = "this is the empty box",
                                        modifier = Modifier.height(100.dp).width(100.dp).align(alignment = Alignment.Center)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun TaskCard(task : Task){
      Card (
          backgroundColor = Color.White,
          //modifier = Modifer
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
                 Text(task.title,
                     fontWeight = FontWeight.Black,
                     fontSize = 18.sp,
                     fontFamily = FontFamily(poppinsRegularFont))
                 Text(
                     task.detail,
                     fontFamily = FontFamily(poppinsRegularFont),
                     color = Color.Gray
                 )
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
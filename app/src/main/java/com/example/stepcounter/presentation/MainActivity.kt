/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package com.example.stepcounter.presentation

import android.health.connect.datatypes.ExercisePerformanceGoal
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.TransformingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberTransformingLazyColumnState
import androidx.wear.compose.material3.AppScaffold
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.EdgeButton
import androidx.wear.compose.material3.ListHeader
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.ScreenScaffold
import androidx.wear.compose.material3.SurfaceTransformation
import androidx.wear.compose.material3.Text
import androidx.wear.compose.material3.lazy.rememberTransformationSpec
import androidx.wear.compose.material3.lazy.transformedHeight
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.example.stepcounter.R
import com.example.stepcounter.presentation.theme.StepCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StepCounterTheme {
                WearFitnessApp()
            }
        }
    }
}
@Composable
fun WearFitnessApp(){
    var steps by remember { mutableIntStateOf(30) }
    var calories by remember { mutableIntStateOf(25) }
    var stepsGoal by remember { mutableIntStateOf(10000) }
    var caloriesGoal by remember { mutableIntStateOf(800) }

   // DailyProgressScreen(
      //  steps = steps,
      //  calories = calories,
     //   stepsGoal= stepsGoal,
     //   caloriesGoal = caloriesGoal,
     //   onAddStep = {
    //        steps++
    //    calories++
  //  }
 //   )
  // HeartRateScreen()
   ModifyGoalScreen()
}
@Composable
fun DailyProgressScreen(
    steps: Int,
    calories: Int,
    stepsGoal: Int,
    caloriesGoal: Int,
    onAddStep: ()-> Unit

){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Daily Progress",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Steps",color = Color.White)

        Text(
            text = "$steps / $stepsGoal",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Calories",color = Color.White)
              Text(
                  text = "$calories / $caloriesGoal",
                  color = Color.White,
                  style = MaterialTheme.typography.titleMedium
              )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {


            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,   // Gold
                contentColor = Color.Black
            )
        ) {
            Text("Add Step")
        }
    }
}
@Composable
fun HeartRateScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Heart Rate",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "72 BPM <3",
            color = Color.White,
            style = MaterialTheme.typography.displaySmall
        )
    }
}
@Composable
fun ModifyGoalScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Modify Goal",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Steps", color= Color.White)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {}) {
                Text("-")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "10000",
                color = Color.White
            )
                    Button(onClick = {}) {
                Text("+")
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = "Calories", color= Color.White)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {


            Spacer(modifier = Modifier.width(6.dp))
                Button(onClick = {}) {
                    Text("-")
                }
            Text(
                text = "800",
                color = Color.White
            )
            Spacer(modifier = Modifier.width(6.dp))
            Button(onClick = {}) {
                Text("+")
            }
        }
    }
}
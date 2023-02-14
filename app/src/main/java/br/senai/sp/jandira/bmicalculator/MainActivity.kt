package br.senai.sp.jandira.bmicalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmicalculator.calculate.calculate
import br.senai.sp.jandira.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorTheme {
                CalculatorScreen();
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CalculatorScreen() {

    var weightState = rememberSaveable() {
        mutableStateOf("")
    }
    var heightState = rememberSaveable() {
        mutableStateOf("")
    }
    var bmiState = rememberSaveable() {
        mutableStateOf("0.0")
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            //HEADER
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.bmi),
                    contentDescription = "",
                    modifier = Modifier.size(128.dp)
                )
                Text(
                    text = stringResource(id = R.string.title),
                    fontSize = 32.sp,
                    color = Color.Blue,
                    letterSpacing = 4.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            //FORM
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(
                        id = R.string.weight_label
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                )
                OutlinedTextField(
                    value = weightState.value,
                    onValueChange = {
                        Log.i("ds2m", it)
                        weightState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, autoCorrect = false)
                )
                Text(
                    text = stringResource(id = R.string.height_label), modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                )
                OutlinedTextField(
                    value = heightState.value,
                    onValueChange = {
                        Log.i("ds2m", it)
                        heightState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, autoCorrect = false)
                )
                Spacer(
                    modifier = Modifier.height(28.dp)
                )
                Button(
                    onClick = {
                    bmiState.value = calculate(weight = weightState.value.toDouble(), height = heightState.value.toDouble()).toString()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = stringResource(id = R.string.button_calculate))
                }
            }
            //FOOTER
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    backgroundColor = Color(red = 79, green = 54, blue = 232),
                    shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)


                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.your_score),
                            color = Color.White,
                            fontSize = 32.sp
                        )
                        Text(
                            text = bmiState.value,
                            color = Color.White,
                            fontSize = 48.sp
                        )
                        Text(
                            text = stringResource(id = R.string.ideal_state),
                            color = Color.White,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                        Row() {
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = stringResource(id = R.string.reset))
                            }
                            Spacer(modifier = Modifier.width(24.dp))
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = stringResource(id = R.string.share))
                            }

                        }
                    }

                }

            }
        }
    }
}


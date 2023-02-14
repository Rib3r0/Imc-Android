package br.senai.sp.jandira.bmicalculator

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmicalculator.model.Client
import br.senai.sp.jandira.bmicalculator.model.Product
import br.senai.sp.jandira.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val p1 = Product()
        p1.id = 100

        val c1 = Client(100,"Pedro")


        setContent {
            BMICalculatorTheme {
            CalculatorScreen();
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun CalculatorScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier =  Modifier.fillMaxSize()) {
            //HEADER
            Column(
                modifier =  Modifier.fillMaxWidth(),
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
                Text(text = stringResource(id = R.string.weight_label), modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp))
                OutlinedTextField(value = "", onValueChange = {},modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                    shape = RoundedCornerShape(16.dp)
                )
                Text(text = stringResource(id = R.string.height_label), modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp))
                OutlinedTextField(value = "", onValueChange = {},modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp) )
                Spacer(modifier = Modifier.height(28.dp))
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp) ) {
                    Text(text = stringResource(id = R.string.button_calculate ) )
                }
            }
            //FOOTER
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    backgroundColor = Color(red = 79, green = 54, blue = 232),
                    shape = RoundedCornerShape(15.dp)


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
                            text = "0.0",
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


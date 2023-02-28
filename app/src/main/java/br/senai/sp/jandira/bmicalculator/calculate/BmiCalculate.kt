package br.senai.sp.jandira.bmicalculator.calculate

import android.content.Context
import androidx.compose.ui.res.stringResource
import androidx.core.content.res.TypedArrayUtils
import br.senai.sp.jandira.bmicalculator.R
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong

fun calculate(weight: Double,height: Double): Double = weight/(height/100).pow(2)

fun getBmiClassification(bmi: Double, context: Context): String {
    return if(bmi <= 18.5){
        context.getString(R.string.underweight)
    }else if(bmi > 18.5 && bmi <= 25.0){
        context.getString(R.string.normal_weight)
    }else if(bmi > 25.0 && bmi <= 30.0){
        context.getString(R.string.over_weight)
    }else if(bmi > 30.0 && bmi <=35.0){
        context.getString(R.string.obesity)
    }else if(bmi > 35.0 && bmi <=40){
        context.getString(R.string.obesity)
    }
    else{
        context.getString(R.string.morbid_obesity)
    }
}
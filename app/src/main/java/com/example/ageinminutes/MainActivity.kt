package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.Button)
        button?.setOnClickListener(){View->
            clickdatepicker(View)
             }

    }

    fun clickdatepicker(view:View){
        val mycalendar= Calendar.getInstance()
        val year=mycalendar.get(Calendar.YEAR)
        val month=mycalendar.get(Calendar.MONTH)
        val date=mycalendar.get(Calendar.DAY_OF_MONTH)
        val dpd=DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val selectdate="$dayOfMonth/${month+1}/$year"
            val textView = findViewById<TextView>(R.id.text1)
                textView.setText(selectdate)
            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate=sdf.parse(selectdate)
            val selectedDateInMinutes=theDate!!.time /60000
            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDatetoMinutes=currentDate!!.time /60000
            val differenceinMinutes=currentDatetoMinutes -selectedDateInMinutes
            val textView2 = findViewById<TextView>(R.id.text2)
            textView2.setText(differenceinMinutes.toString())
        },year,month,date)
        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }
    }
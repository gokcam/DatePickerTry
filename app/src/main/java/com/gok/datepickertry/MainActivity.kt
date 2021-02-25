package com.gok.datepickertry

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun bas (view: View)
    {

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                textView.setText("Seçilen tarih ="+ selectedDate)
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                val selectedDateToMinutes = theDate!!.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateToMinutes = currentDate!!.time / 60000
                val differenceInMinutes = currentDateToMinutes - selectedDateToMinutes

                textView2.setText("Hayatta olduuğun saniye = " + differenceInMinutes.toString())
            },
            year,
            month,
            day
        )

        // 86400000 is milliseconds of 24 Hours. Which is used to restrict the user to select today and future day.
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show() // It is used to show the datePicker Dialog.
    }
}
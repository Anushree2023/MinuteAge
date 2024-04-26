package anu.trial.minuteage

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar
import java.util.Locale


class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
            btnDatePicker.setOnClickListener { view->
                clickDatePicker(view)
                Toast.makeText(this,"Button works",Toast.LENGTH_LONG).show() }



    }
    @SuppressLint("SuspiciousIndentation")
    fun clickDatePicker(view: View)
    {
        val mycal= Calendar.getInstance()
        val yr=mycal.get(Calendar.YEAR)
        val mon=mycal.get(Calendar.MONTH)
        val day=mycal.get(Calendar.DAY_OF_MONTH)
           DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selecteddayOfMonth ->Toast.makeText(this,"The selected year is $selectedyear ,month is $selectedmonth ,day of month is $selecteddayOfMonth"
               ,Toast.LENGTH_LONG).show()

               val selectedDate="$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
               val seldaTextView: TextView = findViewById(R.id.selda)
               seldaTextView.text = selectedDate

              val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

               val theDate=sdf.parse(selectedDate)
               val selectedDate_inMin = theDate!!.time / 60000

               val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
               val currentDateToMinutes=currentDate!!.time/60000

               val differenceInMinutes=currentDateToMinutes - selectedDate_inMin

               val sldinmin: TextView = findViewById(R.id.sldinmin)
             sldinmin.text=differenceInMinutes.toString()








           },yr,mon,day
           ).show()


    }
}
package com.example.ass4

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.time.Month
import java.time.Year
import java.util.*

class DatePickerFragment:DialogFragment(),DatePickerDialog.OnDateSetListener {
    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        return DatePickerDialog(
            activity!!,
            2,
            this,
            day,
            month,
            year
        )
    }
    override fun onDateSet(view: DatePicker,day:Int, month: Int,year: Int) {
        var date : TextView = activity!!.findViewById(R.id.text_date)
        date.text = formatDate(day,month,year)
    }

    override fun onCancel(dialog: DialogInterface) {
        Toast.makeText(activity,"Please select a date.",Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
    private fun formatDate(day:Int, month: Int,year: Int):String{
        var calendar : Calendar = Calendar.getInstance();
        calendar.set(day,month,year)
        val chosenDate = calendar.time
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)
    }

}
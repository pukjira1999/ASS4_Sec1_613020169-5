package com.example.ass4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDatePickDialog(v: View) {
        val newDateFragment = DatePickerFragment()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }

    fun showRegister(v: View) {
        var selectedId: Int = radioGroup.checkedRadioButtonId
        var radioButton: RadioButton = findViewById(selectedId)
        text_show.text =
            "Name : ${edit_name.text}\nPassword: ${edit_pass.text}\nGender : ${radioButton.text}\nE-mail : ${edit_mail.text}\nBirthday : ${text_date.text}"
    }

    fun reset(v: View) {
        edit_name.text.clear()
        edit_pass.text.clear()
        radioGroup.clearCheck()
        edit_mail.text.clear()
        text_date.text = "mm/dd/yy"
        text_show.text = "show Information"

    }
}

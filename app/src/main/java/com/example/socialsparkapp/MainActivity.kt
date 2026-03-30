package com.example.socialsparkapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.MonthDay

class MainActivity : AppCompatActivity() {

    lateinit var txtTimeofDay: EditText

    lateinit var btnSuggest: Button

    lateinit var btnClear: Button

    lateinit var txtSuggestion: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtTimeofDay =findViewById(R.id.txttimeOfDay)
        btnSuggest =findViewById(R.id.btnSuggest)
        btnClear =findViewById(R.id.btnClear)
        txtSuggestion =findViewById(R.id.txtSuggestion)

        btnSuggest.setOnClickListener {
            val timeOfDay =txtTimeofDay.text.toString().trim().lowercase()
            if (timeOfDay.isEmpty()){
                Toast.makeText(this,"Kindly enter the time of day", Toast.LENGTH_SHORT).show()
            }else{
                val suggestion = when{
                    "morning" in timeOfDay-> "Send a warm greeting to a family member."
                    "mid morning" in timeOfDay->"Reach out to a former partner thanking them"
                    "afternoon" in timeOfDay->"Send a funny joke to your best friend"
                    "during the afternoon" in timeOfDay->"Message your girlfriend 'I love you'"
                    "dinner" in timeOfDay->"Quickly check up on your best buddy"
                    "Night" in timeOfDay->"Fall asleep on a call with your girlfriend"
                    else-> "Wrong format of date"
                }
                txtSuggestion.text=suggestion
                Log.i("Tag","Suggestion displayed:$suggestion")
            }
        }
        btnClear.setOnClickListener {
            txtTimeofDay.text.clear()
            txtSuggestion.text =null
            Log.i("Tag","Fields Reset")
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
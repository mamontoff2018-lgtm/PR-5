package com.example.multiwindowlab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupCount)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val count = when (radioGroup.checkedRadioButtonId) {
                R.id.radio3 -> 3
                R.id.radio5 -> 5
                R.id.radio7 -> 7
                R.id.radio10 -> 10
                else -> 5
            }

            val resultIntent = Intent()
            resultIntent.putExtra("CIRCLE_COUNT", count)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
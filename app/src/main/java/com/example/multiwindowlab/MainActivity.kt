package com.example.multiwindowlab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var circlesContainer: LinearLayout
    private var currentCircleCount = 5   // по умолчанию

    private val settingsLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val count = result.data?.getIntExtra("CIRCLE_COUNT", 5) ?: 5
            currentCircleCount = count
            displayCircles(count)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        circlesContainer = findViewById(R.id.circlesContainer)

        findViewById<Button>(R.id.btnSettings).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            settingsLauncher.launch(intent)
        }

        findViewById<Button>(R.id.btnAbout).setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        // Показываем круги при запуске
        displayCircles(currentCircleCount)
    }

    private fun displayCircles(count: Int) {
        circlesContainer.removeAllViews()

        for (i in 1..count) {
            val circle = TextView(this).apply {
                text = "●"
                textSize = 48f
                setPadding(12, 0, 12, 0)
            }
            circlesContainer.addView(circle)
        }
    }
}
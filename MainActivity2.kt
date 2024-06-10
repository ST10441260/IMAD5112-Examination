package com.example.imad5112examination

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    private val minimum = IntArray(7)
    private val maximum = IntArray(7)
    private val dates = Array(7) { "" }
    private val weatherCondition = Array(7) { "" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // get the buttons and the text views
        val min = findViewById<EditText>(R.id.minTemp)
        val max = findViewById<EditText>(R.id.maxTemp)
        val day = findViewById<EditText>(R.id.weatherDay)
        val condition = findViewById<EditText>(R.id.condition)

        val save = findViewById<Button>(R.id.btnSave)
        val display = findViewById<Button>(R.id.btnDisplay)
        val clear = findViewById<Button>(R.id.btnClear)

        // button set on click
        save.setOnClickListener {
            val index = getFirstEmptyIndex()
            if (index != -1) {
                val min = min.text.toString().toIntOrNull()
                val max = max.text.toString().toIntOrNull()
                if (min == null || max == null)
                    Toast.makeText(
                        this,
                        "Please enter valid numbers for the weather", Toast.LENGTH_SHORT).show()
            } else {
                minimum[index] = min
                maximum[index] = max
                dates[index] = day.text.toString()
                weatherCondition[index] = condition.text.toString()
            }
        }
        clear.setOnClickListener {
            min.setText("")
            max.setText("")
            day.setText("")
            condition.setText("")
        }
        display.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            intent.putExtra("minimumArray", minimum)
            intent.putExtra("maximumArray", maximum)
            intent.putExtra("datesArray", dates)
            intent.putExtra("weatherCondition", weatherCondition)
            startActivity(intent)
        }
    }

    private fun getFirstEmptyIndex(): Int {
        for (i in minimum.indices) {
            if (minimum[i] == 0 && maximum[i] == 0 && dates[i].isEmpty() && weatherCondition[i].isEmpty())
                return i
        }

        return -1
    }
}

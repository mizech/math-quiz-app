package de.mizech1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_init.*

class Init : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var start: Button
    var selectedCount = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        spinner = findViewById<Spinner>(R.id.spinner)
        start = findViewById<Button>(R.id.startQuiz)

        val options = arrayOf(5, 10, 20, 40)
        spinner.adapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1,
            options)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext,
                    "Please select an option.", Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedCount = options[position]
            }
        }

        startQuiz.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("selectedCount", selectedCount)
            startActivity(intent)
        }
    }
}

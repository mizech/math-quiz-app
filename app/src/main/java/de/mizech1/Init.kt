package de.mizech1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_init.*

class Init : AppCompatActivity() {
    lateinit var countQuestionsSpinner: Spinner
    lateinit var difficultySpinner: Spinner
    lateinit var start: Button
    lateinit var sharedPrefDifficulty: SharedPreferences
    lateinit var sharedPrefCount: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private val difficulty = "DIFFICULTY"
    private val selectCount = "SELECTED_COUNT"
    var selectedCount = 10
    var selectedDifficulty = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)
        // --------------- References to View-elements ---------------------------------------------
        difficultySpinner = findViewById<Spinner>(R.id.select_difficulty)
        countQuestionsSpinner = findViewById<Spinner>(R.id.select_count_questions)
        start = findViewById<Button>(R.id.startQuiz)
        // -----------------------------------------------------------------------------------------

        // --------------- Access Shared Preferences -----------------------------------------------
        sharedPrefDifficulty = getSharedPreferences(difficulty, 0)
        selectedDifficulty = sharedPrefDifficulty.getInt(difficulty, 0)
        difficultySpinner.setSelection(selectedDifficulty)

        sharedPrefCount = getSharedPreferences(selectCount, 0)
        selectedCount = sharedPrefCount.getInt(selectCount, 10)
        countQuestionsSpinner.setSelection(selectedCount)
        // -----------------------------------------------------------------------------------------

        val options = arrayOf(10, 20, 40, 50)
        countQuestionsSpinner.adapter = ArrayAdapter<Int>(this,
            android.R.layout.simple_list_item_1, options)

        countQuestionsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedCount = 10
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedCount = options[position]
                editor = sharedPrefCount.edit()
                editor.putInt(selectedCount.toString(), 10)
                editor.commit()
            }
        }

        val difficulties = arrayOf(getString(R.string.difficulty_easy),
            getString(R.string.difficulty_hard), getString(R.string.difficulty_very_hard))
        difficultySpinner.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, difficulties)

        difficultySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedDifficulty = 0
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val sDifficulty = difficulties[position]

                when (sDifficulty) {
                    "Easy", "Leicht"  -> {
                        selectedDifficulty = 0
                    }
                    "Hard", "Schwierig" -> {
                        selectedDifficulty = 1
                    }
                    "Very hard", "Sehr schwierig" -> {
                        selectedDifficulty = 2
                    }
                }

                editor = sharedPrefDifficulty.edit()
                editor.putInt(sDifficulty, 0)
                editor.commit()
            }
        }

        startQuiz.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("selectedCount", selectedCount)
            intent.putExtra("difficulty", selectedDifficulty)
            startActivity(intent)
        }
    }
}

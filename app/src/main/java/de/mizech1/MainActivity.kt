package de.mizech1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var selected: Int? = null
    var submitted: Boolean = false
    var index = 0
    var questions: ArrayList<Question>? = null
    var currentQuestion: Question? = null
    var indexCurrentCorrect: Int? = null
    var buttons = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions = Questions().list
        currentQuestion = questions?.get(index)
        indexCurrentCorrect = currentQuestion?.correctOption

        buttons?.add(findViewById<Button>(R.id.optionButton1))
        buttons?.add(findViewById<Button>(R.id.optionButton2))
        buttons?.add(findViewById<Button>(R.id.optionButton3))
        buttons?.add(findViewById<Button>(R.id.optionButton4))

        setButtonColors()

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                selected = index
                setButtonColors()
            }
        }

        submitButton.setOnClickListener {
            submitted = !submitted

            if (submitted) {
                submitButton.setText("Next Question")
                setButtonColors()
            } else {
                index++

                if (index < questions?.size!!) {
                    submitButton.setText("Submit Answer")
                } else {
                    Toast.makeText(this, "Game Over!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun setButtonColors() {
        buttons.forEachIndexed { index, button ->
            setButtonColor(button, Color.BLACK, Color.WHITE)

            if (index == selected) {
                setButtonColor(button, Color.YELLOW, Color.BLACK)
            }

            if (submitted && index == indexCurrentCorrect) {
                setButtonColor(button, Color.GREEN, Color.WHITE)
            }
        }
    }

    fun setButtonColor(button: Button, backgroundColor: Int, textColor: Int) {
        button.setBackgroundColor(backgroundColor)
        button.setTextColor(textColor)
    }

}

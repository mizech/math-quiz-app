package de.mizech1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var selected: Int? = null
    var submitted: Boolean = false
    var textSelected: String = ""
    var index = 0
    var questions: ArrayList<Question>? = null
    var currentQuestion: Question? = null
    var indexCurrentCorrect: Int? = null
    var buttons = ArrayList<Button>()
    var countCorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions = Questions().list
        initQuestion()

        buttons?.add(findViewById<Button>(R.id.optionButton1))
        buttons?.add(findViewById<Button>(R.id.optionButton2))
        buttons?.add(findViewById<Button>(R.id.optionButton3))
        buttons?.add(findViewById<Button>(R.id.optionButton4))

        setButtonColors()
        setQuestionAndOptions()

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

                var correctAnswer = currentQuestion?.correctAnswer

                if (textSelected == correctAnswer) {
                    countCorrectAnswers++
                }
            } else {
                index++

                if (index < questions?.size!!) {
                    initQuestion()
                    submitButton.setText("Submit Answer")
                    setButtonColors()
                    setQuestionAndOptions()
                } else {
                    Toast.makeText(this, "Game Over! $countCorrectAnswers",
                            Toast.LENGTH_SHORT).show()
                    submitButton.visibility = View.GONE
                }
            }
        }
    }

    fun initQuestion() {
        currentQuestion = questions?.get(index)
        indexCurrentCorrect = currentQuestion?.correctOption
        selected = null
        submitted = false
    }

    fun setQuestionAndOptions() {
        textQuestion.setText(currentQuestion?.text)
        optionButton1.setText(currentQuestion?.option1)
        optionButton2.setText(currentQuestion?.option2)
        optionButton3.setText(currentQuestion?.option3)
        optionButton4.setText(currentQuestion?.option4)
    }

    fun setButtonColors() {
        buttons.forEachIndexed { index, button ->
            setButtonColor(button, Color.BLACK, Color.WHITE)

            if (index == selected) {
                setButtonColor(button, Color.YELLOW, Color.BLACK)
                textSelected = button.text.toString()
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

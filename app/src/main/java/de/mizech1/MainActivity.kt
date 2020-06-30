package de.mizech1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var selected: Int? = null
    var hasSubmitted: Boolean = false
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
        reportText()
        progressBar.max = questions?.size ?: 0

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
            if (selected != null) {
                hasSubmitted = !hasSubmitted

                if (hasSubmitted) {
                    submitButton.text = getString(R.string.cont)
                    submitButton.setTextColor(Color.BLUE)
                    toggleButtonsEnabled(false)
                    setButtonColors()
                    progressBar.progress = index + 1

                    if (selected == indexCurrentCorrect) {
                        countCorrectAnswers++
                    }

                    reportText()
                } else {
                    index++

                    if (index < questions?.size!!) {
                        initQuestion()
                        submitButton.text = getString(R.string.submit_answer)
                        submitButton.setTextColor(Color.RED)
                        toggleButtonsEnabled(true)
                        setButtonColors()
                        setQuestionAndOptions()
                    } else {
                        val intent = Intent(this, SummaryReport::class.java)
                        intent.putExtra("score", countCorrectAnswers)
                        intent.putExtra("total", questions?.size!!)
                        startActivity(intent)
                    }
                }
            } else {
                Toast.makeText(this, R.string.select_option, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun reportText() {
        currentScore.text = "${getString(R.string.score)}: $countCorrectAnswers"
        reportText.setText("${index + 1} / ${questions?.size.toString()}")
    }

    fun toggleButtonsEnabled(newState: Boolean = false) {
        buttons.forEach { button ->
            button.isEnabled = newState
        }
    }

    override fun onResume() {
        super.onResume()

        if (index > 0) {
            selected = null
            hasSubmitted = false
            textSelected = ""
            index = 0
            countCorrectAnswers = 0
            progressBar.progress = 0

            setButtonColors()
            initQuestion()
            setQuestionAndOptions()
        }
    }

    fun initQuestion() {
        currentQuestion = questions?.get(index)
        indexCurrentCorrect = currentQuestion?.correctOption
        selected = null
        hasSubmitted = false
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

            if (hasSubmitted && index == indexCurrentCorrect) {
                setButtonColor(button, Color.GREEN, Color.WHITE)
            }
        }
    }

    fun setButtonColor(button: Button, backgroundColor: Int, textColor: Int) {
        button.setBackgroundColor(backgroundColor)
        button.setTextColor(textColor)
    }
}

package de.mizech1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var selected: Int? = null
    var hasSubmitted: Boolean = false
    var textSelected: String = ""
    var index = 0
    var questions: ArrayList<Question?>? = null
    var currentQuestion: Question? = null
    var indexCurrentCorrect: Int? = null
    var buttons = ArrayList<Button>()
    var countCorrectAnswers = 0
    var startTime: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions = QuestionFactory.create()
        initQuestion()
        reportText()
        progressBar.max = questions?.size ?: 0
        startTime = System.currentTimeMillis()

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
                        intent.putExtra("timeNeeded",
                            System.currentTimeMillis() - startTime!!)
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

        resetButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.reset_title))
            builder.setMessage(getString(R.string.reset_message))

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(this, getString(R.string.reset_exec),
                    Toast.LENGTH_SHORT).show()
                resetState()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(this, getString(R.string.operation_cancelled),
                    Toast.LENGTH_SHORT).show()
            }

            builder.show()
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
            resetState()
        }
    }

    fun resetState() {
        selected = null
        hasSubmitted = false
        textSelected = ""
        index = 0
        countCorrectAnswers = 0
        progressBar.progress = 0
        questions = QuestionFactory.create()
        startTime = System.currentTimeMillis()

        setButtonColors()
        initQuestion()
        setQuestionAndOptions()
        toggleButtonsEnabled(true)
        reportText()
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

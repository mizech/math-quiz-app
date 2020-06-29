package de.mizech1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summary_report.*

class SummaryReport : AppCompatActivity() {
    val messages = listOf("Congratulations. Excellent done.", "Great done. Congratulations",
        "Nicely done.", "Better luck next time.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_report)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        var message = ""

        when (score) {
            10 -> {
                message = messages[0]
                smileyImage.setImageResource(R.drawable.baseline_emoji_events_black_48)
            }
            in 8..9 -> {
                message = messages[1]
                smileyImage.setImageResource(R.drawable.baseline_mood_black_48)
            }
            in 6..7 -> {
                message = messages[2]
                smileyImage.setImageResource(R.drawable.baseline_sentiment_satisfied_black_48)
            }
            else -> {
                message = messages[3]
                smileyImage.setImageResource(R.drawable.baseline_sentiment_dissatisfied_black_48)
            }
        }

        congratulations.text = message
        scoreReport.setText(
            "You got ${score.toString()} out of ${total.toString()} questions correct.")

        restartGame.setOnClickListener {
            finish()
        }
    }
}

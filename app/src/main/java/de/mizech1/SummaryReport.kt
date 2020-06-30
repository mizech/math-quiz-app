package de.mizech1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summary_report.*

class SummaryReport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_report)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        var message = ""

        when (score) {
            10 -> {
                message = getString(R.string.first_rank)
                smileyImage.setImageResource(R.drawable.baseline_emoji_events_black_48)
            }
            in 8..9 -> {
                message = getString(R.string.second_rank)
                smileyImage.setImageResource(R.drawable.baseline_mood_black_48)
            }
            in 6..7 -> {
                message = getString(R.string.third_rank)
                smileyImage.setImageResource(R.drawable.baseline_sentiment_satisfied_black_48)
            }
            else -> {
                message = getString(R.string.fourth_rank)
                smileyImage.setImageResource(R.drawable.baseline_sentiment_dissatisfied_black_48)
            }
        }

        congratulations.text = message
        scoreReport.setText(
            "${getString(R.string.first_part_summary)} ${score.toString()} " +
                    "${getString(R.string.middle_part_summary)} ${total.toString()} " +
                    "${getString(R.string.last_part_summary)}.")

        restartGame.setOnClickListener {
            finish()
        }
    }
}

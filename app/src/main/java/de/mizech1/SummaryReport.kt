package de.mizech1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summary_report.*
import kotlin.math.round

class SummaryReport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_report)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        val longTimeNeeded = intent.getLongExtra("timeNeeded", 0)
        var message = ""

        when (score) {
            10 -> {
                message = getString(R.string.first_rank)
            }
            in 8..9 -> {
                message = getString(R.string.second_rank)
            }
            in 6..7 -> {
                message = getString(R.string.third_rank)
            }
            else -> {
                message = getString(R.string.fourth_rank)
            }
        }

        timeNeeded.setText(createTimeNeeded(longTimeNeeded))

        congratulations.text = message

        val percent = (score * 100) / total
        var rounded = (round(percent * 10.0)) / 10.0

        scoreReport.setText(
            "${getString(R.string.first_part_summary)} ${score.toString()} (${rounded}%) " +
                    "${getString(R.string.middle_part_summary)} ${total.toString()} " +
                    "${getString(R.string.last_part_summary)}.")

        restartGame.setOnClickListener {
            finish()
        }
    }

    fun createTimeNeeded(time: Long): String {
        val totalSeconds = time / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60

        return "${resources.getString(R.string.time_needed)} $minutes:$seconds"
    }
}

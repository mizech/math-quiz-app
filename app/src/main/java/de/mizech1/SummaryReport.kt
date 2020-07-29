package de.mizech1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summary_report.*
import kotlin.math.pow
import kotlin.math.round

class SummaryReport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_report)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        val longTimeNeeded = intent.getLongExtra("timeNeeded", 0)
        var message = ""

        val percent = (score * 100) / total
        var rounded = (round(percent * 10.0)) / 10.0

        when (rounded) {
            in 90.0..100.0 -> {
                message = getString(R.string.first_rank)
            }
            in 80.0..89.9 -> {
                message = getString(R.string.second_rank)
            }
            in 60.0..79.9 -> {
                message = getString(R.string.third_rank)
            }
            else -> {
                message = getString(R.string.fourth_rank)
            }
        }

        timeNeeded.setText(createTimeNeeded(longTimeNeeded))

        congratulations.text = message

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
        val minutes = "0${totalSeconds / 60}".takeLast(2)
        val seconds = "0${totalSeconds % 60}".takeLast(2)

        return "${resources.getString(R.string.time_needed)} $minutes:$seconds"
    }
}

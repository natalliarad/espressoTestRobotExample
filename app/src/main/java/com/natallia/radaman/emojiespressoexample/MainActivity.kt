package com.natallia.radaman.emojiespressoexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBad.setOnClickListener { calculateTip(BAD_TIP_PERCENTAGE) }
        buttonOkay.setOnClickListener { calculateTip(OKAY_TIP_PERCENTAGE) }
        buttonGreat.setOnClickListener { calculateTip(GREAT_TIP_PERCENTAGE) }
    }

    private fun calculateTip(percentage: Double) {
        inputAmount.text?.toString()?.let { bill ->
            if (bill.isNotEmpty()) {
                val billTotal = bill.toDouble()
                var tip = billTotal * percentage
                if (switchRound.isChecked) {
                    val additionalTip = Math.ceil(tip + billTotal) - (tip + billTotal)
                    tip += additionalTip
                }
                showResult(tip, tip + billTotal, tip / billTotal * 100)
            }
        }
    }

    private fun showResult(tip: Double, total: Double, percentage: Double) {
        textTip.text = String.format("%.2f", tip)
        textTotal.text = String.format("%.2f", total)
        textPercent.text = String.format("%.2f", percentage) + "%"
    }

    companion object {
        const val BAD_TIP_PERCENTAGE = 0.15
        const val OKAY_TIP_PERCENTAGE = 0.18
        const val GREAT_TIP_PERCENTAGE = 0.20
    }
}
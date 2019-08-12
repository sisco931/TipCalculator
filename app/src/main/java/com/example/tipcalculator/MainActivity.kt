package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBarNumberOfPeople.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewNumberOfPeople.text = progress.toString()
                calculateTip()

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //To change body of created functions use File | Settings | File Templates.
            }

        })

        seekBarTipPercent.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewTip.text = progress.toString()+ "%"
                calculateTip()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //To change body of created functions use File | Settings | File Templates.
            }

        })

        buttonCalculate.setOnClickListener {
            calculateTip()
        }
    }
    fun calculateTip()
    {
        if (editTextEditBillAmount.length() > 0 && seekBarNumberOfPeople.progress > 0) {

                val totalBill = editTextEditBillAmount.text.toString().toInt()

                val tipPercent = seekBarTipPercent.progress

                val numberOfPeople = seekBarNumberOfPeople.progress

                val tipAmount = totalBill * tipPercent / 100

                val totalPayment = tipAmount + totalBill

                val eachShare = totalPayment / numberOfPeople

                textViewTotalBill.text = "Total Payment Is $${totalPayment} Each Persons Share is $${eachShare}"
            } else {
                Toast.makeText(applicationContext, "Please Enter Bill Amount to Continue", Toast.LENGTH_SHORT).show()
            }
    }
}




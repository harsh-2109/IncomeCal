package com.hpandya.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Spinner
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var grossAnnualIncome:TextInputEditText
    lateinit var totalTaxAmount:TextView
    lateinit var federalTax:TextView
    lateinit var provincialTax:TextView
    lateinit var cppEiPremiums:TextView
    lateinit var afterTaxIncome:TextView
    lateinit var provinceSpinner:Spinner
    lateinit var workingHours:TextInputEditText
    lateinit var hourlyWage:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise the value
        grossAnnualIncome= findViewById(R.id.gross_amount)
        totalTaxAmount=findViewById(R.id.total_tax_amount_text_view)
        federalTax=findViewById(R.id.federal_tax_amount_text_view)
        provincialTax=findViewById(R.id.provincial_tax_amount_text_view)
        cppEiPremiums=findViewById(R.id.cpp_ei_premiums_amount_text_view)
        afterTaxIncome=findViewById(R.id.after_tax_income_amount_text_view)
        provinceSpinner=findViewById(R.id.province_spinner)
        workingHours=findViewById(R.id.working_hours_text)
        hourlyWage=findViewById(R.id.hourly_wage_amount_text_view)

        grossAnnualIncome.addTextChangedListener{
            var grossIncome:String=grossAnnualIncome.text.toString()
            if (grossIncome == ""){
                grossIncome="0"
            }
            val totalAmount=Integer.valueOf(grossIncome)
            val hoursOfWork=workingHours.text.toString()

            if (totalAmount<49020) {
                val totalTax = totalAmount * 0.1969
                totalTaxAmount.text = (totalTax).toString()
                federalTax.text = (totalAmount * 0.0863).toString()
                provincialTax.text = (totalAmount * 0.0448).toString()
                cppEiPremiums.text = (totalAmount * 0.0657).toString()
                afterTaxIncome.text = (totalAmount - totalTax).toString()

                hourlyWage.text=((totalAmount/52)/hoursOfWork.toDouble()).toString()
            }else if (totalAmount>=49020 == totalAmount<98040){
                val totalTax = totalAmount * 0.1969
                totalTaxAmount.text = (totalTax).toString()
                federalTax.text = (totalAmount * 0.0863).toString()
                provincialTax.text = (totalAmount * 0.0448).toString()
                cppEiPremiums.text = (totalAmount * 0.0657).toString()
                afterTaxIncome.text = (totalAmount - totalTax).toString()
            }
        }
    }

}
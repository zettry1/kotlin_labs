package com.example.miu_mobile_assignemnt

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainTable = findViewById<TableLayout>(R.id.table)
        val addButton = findViewById<Button>(R.id.addButton)
        val input1 = findViewById<EditText>(R.id.input1)
        val input2 = findViewById<EditText>(R.id.input2)

        addButton.setOnClickListener {
            if (input1.text.toString().isNotEmpty() && input2.text.toString().isNotEmpty()) {
                val row = createRow(this, input1.text.toString(), input2.text.toString())
                mainTable.addView(row)

                input1.text.clear()
                input2.text.clear()
                input1.requestFocus()
            } else {

            }
        }
    }

    private fun createRow(context: Context, name: String, version: String): TableRow {
        val row = TableRow(context)
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT)
        row.layoutParams = layoutParams
        row.setPadding(10)

        val view1= TextView(context)
        view1.text=name
        row.addView(view1)
        val view2= TextView(context)
        view2.text=version

        row.addView(view2)
        return row;
    }


}
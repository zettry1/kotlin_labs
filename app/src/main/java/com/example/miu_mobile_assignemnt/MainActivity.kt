package com.example.miu_mobile_assignemnt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.example.miu_mobile_assignemnt.model.Product

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0, 11, 22))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00, 11, 22))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00, 11, 22))
        products.add(
            Product(
                "Logitech Keyboard",
                "Logitech - PRO X\nTKL LIGHTSPEED Wireless",
                199.00,
                11,
                22
            )
        )
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00, 11, 22))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
package com.kubra.koubitirme.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kubra.koubitirme.R

class RegisterActivity : AppCompatActivity() {

    private var singUp: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        singUp = findViewById(R.id.button1)
    }
}

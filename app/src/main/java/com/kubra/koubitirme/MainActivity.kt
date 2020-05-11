package com.kubra.koubitirme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var email: EditText? = null
    private var password: EditText? = null
    private var btn1: Button? = null
    private var btn2: ImageButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.editText)
        password = findViewById(R.id.editText2)
        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.register_button)

        btn2?.setOnClickListener {
            val intent = Intent(this@MainActivity,RegisterActivity::class.java)
            startActivity(intent)
        }


    }








}

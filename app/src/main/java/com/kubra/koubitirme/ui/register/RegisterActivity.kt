package com.kubra.koubitirme.ui.register

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.kubra.koubitirme.R
import com.kubra.koubitirme.database.UserDAO
import com.kubra.koubitirme.database.UserDatabase
import com.kubra.koubitirme.models.User
import com.kubra.koubitirme.ui.MainActivity


class RegisterActivity : AppCompatActivity() {

    private var edtName: EditText? = null
    private var edtLastName: EditText? = null
    private var edtEmail: EditText? = null
    private var edtPassword: EditText? = null
    private var btRegister: Button? = null
    private var userDao: UserDAO? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtName=findViewById(R.id.nameinput)
        edtLastName=findViewById(R.id.lastnameinput)
        edtEmail=findViewById(R.id.emailinput)
        edtPassword=findViewById(R.id.passwordinput)
        btRegister=findViewById(R.id.register)

        this.applicationContext.deleteDatabase("user_account_info")
        userDao = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "user_account_info"
        ).allowMainThreadQueries().build().getUserDao()

        btRegister?.setOnClickListener {
            if(!isEmpty()){
                var user = User(
                    edtName?.text.toString(), edtLastName?.text.toString(),
                    edtEmail?.text.toString(), edtPassword?.text.toString()
                )
                userDao?.insert(user)
                startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
            }else{
                Toast.makeText(this@RegisterActivity,"Field is Empty",Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun isEmpty(): Boolean {
        return TextUtils.isEmpty(edtEmail!!.text.toString()) ||
                TextUtils.isEmpty(edtPassword!!.text.toString()) ||
                TextUtils.isEmpty(edtName!!.text.toString()) ||
                TextUtils.isEmpty(edtLastName!!.text.toString())
    }
}

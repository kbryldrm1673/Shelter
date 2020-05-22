package com.kubra.koubitirme.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.kubra.koubitirme.R
import com.kubra.koubitirme.database.UserDAO
import com.kubra.koubitirme.database.UserDatabase
import com.kubra.koubitirme.ui.quiz.QuizActivity
import com.kubra.koubitirme.ui.register.RegisterActivity


class MainActivity : AppCompatActivity(){

    private var btSignIn : Button?=null
    private var btSignUp :ImageButton?=null
    private var edtEmail:EditText?=null
    private var edtPassword:EditText?=null
    private var database:UserDatabase?=null
    private var userDao:UserDAO?=null

    private var btn3:ImageButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        var  mp : MainRepository?=null
//        mp?.getAnimalImage();

        database = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "user_account_info"
        ).allowMainThreadQueries().build()

        userDao = database?.getUserDao()

        btSignIn = findViewById(R.id.btSignIn)
        btSignUp =findViewById(R.id.btSignUp)
        edtEmail =findViewById(R.id.emailinput)
        edtPassword=findViewById(R.id.passwordinput)
        btn3=findViewById(R.id.quiz_button)


        btSignUp?.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        btSignIn?.setOnClickListener {

            if(TextUtils.isEmpty(edtEmail!!.text.toString())){
                Toast.makeText(this@MainActivity,"Email Empty",Toast.LENGTH_SHORT).show()
            }else if(TextUtils.isEmpty(edtPassword!!.text.toString())){
                Toast.makeText(this@MainActivity,"Empty Password",Toast.LENGTH_SHORT).show()
            }else{
                if(!textEmpty()){
                    run {
                        var user = userDao?.getUser(edtEmail?.text.toString(), edtPassword?.text.toString())
                        if (user!=null)  {
                            val  intent= Intent(this@MainActivity, QuizActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this@MainActivity,
                                "Unregistered user, or incorrect",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                }else{
                    Toast.makeText(this@MainActivity,"Empty Fields",Toast.LENGTH_SHORT).show()
                }
            }


        }


    }

    private fun textEmpty(): Boolean {
        return TextUtils.isEmpty(edtEmail!!.text.toString()) || TextUtils.isEmpty(edtPassword!!.text.toString())
    }




}

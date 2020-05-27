package com.kubra.koubitirme.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kubra.koubitirme.ApiService
import com.kubra.koubitirme.R
import com.kubra.koubitirme.RetrofitClient
import com.kubra.koubitirme.animalModel.UserGET
import com.kubra.koubitirme.ui.quiz.QuizActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(){

    private var edtEmail:EditText?=null
    private var edtPassword:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        edtEmail =findViewById(R.id.emailinput)
        edtPassword=findViewById(R.id.passwordinput)


        val btSignIn: View = findViewById(R.id.btSignIn)

        btSignIn.setOnClickListener {
            val intent=Intent(this@MainActivity,QuizActivity::class.java)
            startActivity(intent)
        }


       fun signin(email: String, password: String){
            val retIn = RetrofitClient.getClient().create(ApiService::class.java)
            val signInInfo = UserGET(email, password)
            retIn.signin(signInInfo).enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.code() == 200) {
                        Toast.makeText(this@MainActivity, "Login success!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@MainActivity, "Login failed!", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

        val fab1: View = findViewById(R.id.singUpFab)
        fab1?.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }






}

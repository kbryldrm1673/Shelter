package com.kubra.koubitirme.ui.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kubra.koubitirme.ApiService
import com.kubra.koubitirme.R
import com.kubra.koubitirme.RetrofitClient
import com.kubra.koubitirme.animalModel.UserPOST
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {


    private var btRegister: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        btRegister=findViewById(R.id.register)
        Log.e("selim","selam")

    }

        private fun signup(name: String, lastname: String, email: String, password: String) {
            val retIn = RetrofitClient.getClient().create(ApiService::class.java)
            val registerInfo = UserPOST(name, lastname, email, password)

            btRegister?.setOnClickListener {
                retIn.registerUser(registerInfo).enqueue(object : Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Toast.makeText(this@RegisterActivity, t.message, Toast.LENGTH_SHORT).show()
                        Log.e("selimm","selam")
                    }

                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        if (response.code() == 201) {
                            Toast.makeText(this@RegisterActivity, "Registration success!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@RegisterActivity, MainActivity::class.java)

                        } else {
                            Toast.makeText(this@RegisterActivity, "Registration failed!", Toast.LENGTH_SHORT).show()
                            Log.e("selimmm","selam")
                        }
                    }
                })
            }


        }





}

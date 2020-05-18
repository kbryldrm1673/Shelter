package com.kubra.koubitirme.add


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.kubra.koubitirme.R
import com.kubra.koubitirme.ui.quiz.QuizActivity
import kotlinx.android.synthetic.main.activity_add_answer.*


class AddAnswerActivity : AppCompatActivity() {

    private lateinit var viewModel: AddAnswerModel
    private  lateinit var answer: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_answer)

        viewModel = ViewModelProviders.of(this).get(AddAnswerModel::class.java)

        save_button.setOnClickListener {
            val intent = Intent(this@AddAnswerActivity,QuizActivity::class.java)
            startActivity(intent)
            answer=name.toString()

            Toast.makeText(this, "Ekleme başarılı", Toast.LENGTH_LONG).show()
        }


    }

}







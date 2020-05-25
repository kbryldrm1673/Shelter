package com.kubra.koubitirme.ui.quiz


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import com.kubra.koubitirme.AnimalList
import com.kubra.koubitirme.R
import com.kubra.koubitirme.models.Question
import kotlinx.android.synthetic.main.activity_quiz.*


class QuizActivity : AppCompatActivity() {

    private var viewModel: QuizViewModel?= null
    private var questionList:List<Question> = arrayListOf()
    private var qIndex:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        viewModel = ViewModelProviders.of(this).get(QuizViewModel::class.java)


        viewModel?.allQuestions?.observe(this, Observer {
            if(it.isNotEmpty()){
                questionList=it
                setViews()

                nextFab.setOnClickListener {
                    val answer= findViewById<Chip>(option_group.checkedChipId)
                    option_group.clearCheck()

                    qIndex++

                    if(qIndex<questionList.size){
                        setViews()
                    }else{
                        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@QuizActivity, AnimalList::class.java))
                    }
                }
            }

        })

    }

    private fun setViews(){
        question.text=questionList[qIndex].question
        option_a.text=questionList[qIndex].optionA
        option_b.text=questionList[qIndex].optionB

    }

}


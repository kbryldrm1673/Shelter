package com.kubra.koubitirme.database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kubra.koubitirme.models.Question

@Database(entities = arrayOf(Question::class),version = 1 )
abstract class QuestionDatabase:RoomDatabase() {

    abstract fun questionDao(): QuestionDAO

    companion object {
        @Volatile
        var INSTANCE: QuestionDatabase? = null

        @Synchronized
        fun getInstance(context: Context): QuestionDatabase {
            if (INSTANCE == null) {
                context.getApplicationContext().deleteDatabase("question_db")

                INSTANCE = Room.databaseBuilder(context.applicationContext, QuestionDatabase::class.java, "question_db"
                )
                    .addCallback(roomDbCallback)
                    .build()
            }

            return INSTANCE as QuestionDatabase
        }

        private val roomDbCallback = object: RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsyncTask(INSTANCE).execute()
            }
        }



        class PopulateAsyncTask(private val db: QuestionDatabase?): AsyncTask<Void, Void, Void>() {

            private val dao: QuestionDAO? by lazy { db?.questionDao() }

            override fun doInBackground(vararg params: Void?): Void? {
                val question =Question(
                    question = "Daha önce evcil hayvan beslediniz mi?",
                    optionA="Evet",
                    optionB="Hayır",
                    answer = ""
                )
                dao?.addQuestion(question)

                val question1=Question(
                    question = "Eviniz müstakil mi?",
                    optionA = "Evet",
                    optionB ="Hayır",
                    answer = ""
                )
                dao?.addQuestion(question1)
                val question2 =Question(
                    question = "Engelli bir canlının bakımını üstlenmek ister misiniz?",
                    optionA="Evet",
                    optionB = "Hayır",
                    answer=""
                )
                dao?.addQuestion(question2)
                val question3=Question(
                    question="Barınaktan hangi tür hayvan sahiplenmek istersiniz?",
                    optionA="Kedi",
                    optionB="Köpek",
                    answer = ""
                )
                dao?.addQuestion(question3)
                val question4=Question(
                    question="Evde bakımını üstlendiğiniz başka hayvan var mı?",
                    optionA="Evet",
                    optionB="Hayır",
                    answer=""
                )
                dao?.addQuestion(question4)

                return null
            }

        }

    }

}
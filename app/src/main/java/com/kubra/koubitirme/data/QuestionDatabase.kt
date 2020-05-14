package com.kubra.koubitirme.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kubra.koubitirme.model.Question

@Database(entities = arrayOf(Question::class), version = 1)
abstract class QuestionDatabase:RoomDatabase() {

    abstract fun questionDao(): QuestionDAO

    companion object {
        @Volatile
        var INSTANCE: QuestionDatabase? = null

        @Synchronized
        fun getInstance(context: Context): QuestionDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDatabase::class.java,
                    "question_db"
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
                var question = Question(
                    question = "Nasıl bir evde yaşıyorsunuz?",
                    optionA = "Ayşe",
                    optionB = "Kübra",
                    optionC = "Berçem",
                    answer = "Kübra"
                )
                dao?.addQuestion(question)

                var question1 = Question(
                    question = "Hangi Şehirde Yaşıyorsunuz?",
                    optionA = "İstanbul",
                    optionB = "Ankara",
                    optionC = "İzmir",
                    answer = "İstanbul"
                )
                dao?.addQuestion(question1)

                return null
            }

        }

    }

}
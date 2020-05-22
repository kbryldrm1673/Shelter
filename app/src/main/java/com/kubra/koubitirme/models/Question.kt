package com.kubra.koubitirme.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(

    @PrimaryKey(autoGenerate = true)
    var qid: Int ?=null,

    var question: String?=null,

    @ColumnInfo(name = "option_a")
    var optionA: String?=null,

    @ColumnInfo(name = "option_b")
    var optionB: String?=null,

    var answer: String?=null
)

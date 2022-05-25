package me.camila.bonfire_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity  //As tabelas do SQlite são representadas por Entitys

data class PostEntity( //Construtores da data class
    @PrimaryKey
    val id: Int?, // ID será a chave primária
    val date: String,
    val userPost: String
)
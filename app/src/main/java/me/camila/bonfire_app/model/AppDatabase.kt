package me.camila.bonfire_app.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Disponibilização do DAO e conexão com o banco de dados

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)  //Indica a Entidade do banco de dados e Versão

abstract class AppDatabase: RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {

        fun getDataBase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()
        }


    }
}
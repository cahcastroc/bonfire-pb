package me.camila.bonfire_app.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {
    @Query("SELECT * FROM PostEntity")
    fun findAll(): LiveData<List<PostEntity>>

    @Insert
    fun create(post: PostEntity)

//    @Query("SELECT MAX(id) FROM PostEntity")
//    fun findId (): Int

    @Query("DELETE FROM PostEntity")
    fun deleteAll()
}
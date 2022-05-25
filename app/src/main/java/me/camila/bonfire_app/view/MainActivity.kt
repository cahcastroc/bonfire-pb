package me.camila.bonfire_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import me.camila.bonfire_app.R
import me.camila.bonfire_app.model.PostEntity
import me.camila.bonfire_app.viewmodel.PostViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)


        val viewPost = findViewById<TextView>(R.id.tvPost)
        val viewDate = findViewById<TextView>(R.id.tvDate)
        val viewId = findViewById<TextView>(R.id.tvId)
        var id = 0

//----------------- Obervação do Livedata(post no view model)
        postViewModel.post.observe(this){
            viewId.text="" //TV -Inicia sem texto
            viewPost.text=""
            viewDate.text=""



            it.forEach{post -> // Add na lista post(livedata no viewmodel)
                viewId.append("${post.id}\n")
                viewPost.append("${post.userPost}\n")
                viewDate.append("${post.date}\n")

            }
        }

//-------------Criação de post

        val inputPost  = findViewById<EditText>(R.id.etPost)
        val btPost = findViewById<Button>(R.id.btPost)

        btPost.setOnClickListener {


            // Condicional para incluir o ID
            if (id ==0){
                id = 1
            } else{
                id++
            }

            val datePost = date()
            val textPost = inputPost.text.toString()
            val newPost = PostEntity(id,datePost,textPost ) //Dados que vão para o data class-entity
            postViewModel.create(newPost)  //Cria o post no db

            inputPost.setText("") //Limpa o input após add o post
        }

        val btDelete = findViewById<Button>(R.id.btDelete)

        btDelete.setOnClickListener {
            postViewModel.deleteAll()
        }
    }


    private fun date(): String {
        val date = Calendar.getInstance().time

        val dateTimeFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

        return dateTimeFormat.format(date)
    }
}


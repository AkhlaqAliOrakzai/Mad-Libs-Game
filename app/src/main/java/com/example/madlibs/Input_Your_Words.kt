package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset
import kotlin.random.Random
import kotlin.reflect.typeOf

class Input_Your_Words : AppCompatActivity() {
    val list = ArrayList<String>()
    var text = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_your_words)
    }

    override fun onStart() {
        super.onStart()
        var word = ""
//        var input_stream = baseContext.resources.openRawResource(R.raw.madlib1)
//        text = input_stream.readBytes().toString(Charset.defaultCharset())

        val file: String = "src/resources/madlib0.txt"
        val text = File(file).readText()

        //for taking out the words which are to be filled
        for(value in 0..text.length-1){
            if(text[value]=='<'){
                for(newValue in value+1..text.length-1){
                    if(text[newValue]!='>'){
                        word+=text[newValue]
                    }
                    else{
                        break;
                    }
                }
                list.add(word)
                println(word)
                word = ""

            }
        }
        var inp = findViewById<TextView>(R.id.textView4)
        inp.setText(list.removeAt(0))

        var wordsLeft = findViewById<TextView>(R.id.textView3)
        wordsLeft.text = "Words Left: " + (list.size+1)

    }
    fun okClick(view: View){
        var inp = findViewById<TextView>(R.id.textView4)

        var goToNextAct = false
        var removeWord = ""
        if(list.isNullOrEmpty()){
            goToNextAct = true

        }
        else{
            removeWord = list.removeAt(0)
            inp.text = removeWord
            //

            var wordsLeft = findViewById<TextView>(R.id.textView3)
            wordsLeft.text = "Words Left: " + (list.size+1)
        }

        var newText = ""
        var inpEditText = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
        var isLessThan = false
        //Replacing the words with input values
        for(i in 0..text.length-1){
            if(text[i]=='<'){
                isLessThan = true
                for(j in 0..inpEditText.length - 1){
                    newText += inpEditText[j]
                }
            }
            else if(isLessThan == false){
                newText += text[i]
            }
            else if(text[i]=='>'){
                for(k in i+1..text.length-1){
                    newText += text[k]
                }
                break
            }

        }
        text = newText
        var inpEmpty = findViewById<EditText>(R.id.editTextTextPersonName)
        inpEmpty.setText("")

        if(goToNextAct){
            var intent = Intent(this, Story :: class.java)
            intent.putExtra("story",text)
            startActivity(intent)
        }

    }
}
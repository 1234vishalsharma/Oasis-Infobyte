package com.example.my_calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.RuntimeException
import java.util.function.DoubleSupplier

class MainActivity : AppCompatActivity() {

    lateinit var inputboxone : TextView
    lateinit var inputboxtwo : TextView

    lateinit var acbtn : Button          // done
    lateinit var clsbtn : Button         // done
    lateinit var bracesopen : Button     // done
    lateinit var bracesclose : Button    // done
    lateinit var sinbtn : Button         // done
    lateinit var cosbtn : Button         // done
    lateinit var tanbtn : Button         // done
    lateinit var logbtn : Button         // done
    lateinit var powerbtn : Button

    lateinit var button9 : Button           // done
    lateinit var button8 : Button           // done
    lateinit var button7 : Button           // done
    lateinit var button6 : Button           // done
    lateinit var button5 : Button           // done
    lateinit var button4 : Button           // done
    lateinit var button3 : Button           // done
    lateinit var button2 : Button           // done
    lateinit var button1 : Button           // done
    lateinit var button0 : Button           // done

    lateinit var mulbtn : Button            // done
    lateinit var divbtn : Button            // done
    lateinit var addbtn : Button            // done
    lateinit var subbtn : Button            // done

    lateinit var equalbtn : Button          // done
    lateinit var doublezerobtn : Button     // done
    lateinit var piebtn : Button            // done
    lateinit var percentbtn : Button        // done
    lateinit var lnbtn : Button             // done
    lateinit var rootbtn : Button           // done
    lateinit var decimalbtn : Button        // done

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputboxone=findViewById(R.id.inputboxone)
        inputboxtwo=findViewById(R.id.inputboxtwo)

        acbtn=findViewById(R.id.ac)
        clsbtn=findViewById(R.id.cls)
        bracesopen=findViewById(R.id.bracesopen)
        bracesclose=findViewById(R.id.bracesclose)
        sinbtn=findViewById(R.id.sin)
        cosbtn=findViewById(R.id.cos)
        tanbtn=findViewById(R.id.tan)
        logbtn=findViewById(R.id.log)
        powerbtn=findViewById(R.id.pow)

        button9=findViewById(R.id.btn9)
        button8=findViewById(R.id.btn8)
        button7=findViewById(R.id.btn7)
        button6=findViewById(R.id.btn6)
        button5=findViewById(R.id.btn5)
        button4=findViewById(R.id.btn4)
        button3=findViewById(R.id.btn3)
        button2=findViewById(R.id.btn2)
        button1=findViewById(R.id.btn1)
        button0=findViewById(R.id.btn0)
        doublezerobtn=findViewById(R.id.btn00)

        mulbtn=findViewById(R.id.optmul)
        divbtn=findViewById(R.id.optdiv)
        subbtn=findViewById(R.id.optsub)
        addbtn=findViewById(R.id.optadd)

        equalbtn=findViewById(R.id.equal)
        piebtn=findViewById(R.id.optpi)
        percentbtn=findViewById(R.id.percent)
        lnbtn=findViewById(R.id.ln)
        rootbtn=findViewById(R.id.root)
        decimalbtn=findViewById(R.id.optdec)


        doublezerobtn.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"00")
        }
        button0.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"0")
        }
        button1.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"1")
        }
        button2.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"2")
        }
        button3.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"3")
        }
        button4.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"4")
        }
        button5.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"5")
        }
        button6.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"6")
        }
        button7.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"7")
        }
        button8.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"8")
        }
        button9.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"9")
        }
        bracesclose.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+")")
        }
        bracesopen.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"(")
        }
        piebtn.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"3.142")
            inputboxtwo.text=(piebtn.text.toString())
        }
        decimalbtn.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+".")
        }
        sinbtn.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"sin")
        }
        cosbtn.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"cos")
        }
        tanbtn.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"tan")
        }
        lnbtn.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"ln")
        }
        logbtn.setOnClickListener {
            inputboxone.text=(inputboxone.text.toString()+"log")
        }
        addbtn.setOnClickListener {
            val str: String=inputboxone.text.toString()
            if(!str.get(index = str.length-1).equals("+")){
                inputboxone.text=(inputboxone.text.toString()+"+")
            }
        }
        subbtn.setOnClickListener {
            val str: String=inputboxone.text.toString()
            if(!str.get(index = str.length-1).equals("-")){
                inputboxone.text=(inputboxone.text.toString()+"-")
            }
        }
        mulbtn.setOnClickListener {
            val str: String=inputboxone.text.toString()
            if(!str.get(index = str.length-1).equals("*")){
                inputboxone.text=(inputboxone.text.toString()+"*")
            }
        }
        divbtn.setOnClickListener {
            val str:String = inputboxone.text.toString()
            if(!str.get(index=str.length-1).equals("/")){
                inputboxone.text=(inputboxone.text.toString()+"/")
            }
        }
        rootbtn.setOnClickListener {
            if(inputboxone.toString().isEmpty()){
                Toast.makeText(this, "Enter a valid number first", Toast.LENGTH_SHORT).show()
            }
            else{
                val str : String = inputboxone.text.toString()
                val res = Math.sqrt(str.toDouble())
                val result=res.toString()
                inputboxone.text=result
            }
        }
        acbtn.setOnClickListener {
            inputboxone.text=""
            inputboxtwo.text=""
        }
        clsbtn.setOnClickListener {
            var str: String=inputboxone.text.toString()
            if(!str.equals("")){
                str=str.substring(0,str.length-1)
                inputboxone.text=str
            }
        }
        powerbtn.setOnClickListener {
            if(inputboxone.toString().isEmpty()){
                Toast.makeText(this, "Pleas enter a valid number", Toast.LENGTH_SHORT).show()
            }
            else{
                inputboxone.text=(inputboxone.text.toString()+"^")
            }
        }
        percentbtn.setOnClickListener {
            if(inputboxone.text.toString().isEmpty()){
                Toast.makeText(this, "Format Error", Toast.LENGTH_SHORT).show()
            }
            else{
                inputboxone.text=(inputboxone.toString()+"%")
            }
        }
        equalbtn.setOnClickListener {
            val str:String=inputboxone.text.toString()
            val result=evaluate(str)
            val ans=result.toString()
            inputboxtwo.text=ans
            inputboxone.text=str
        }
    }

    fun evaluate(str: String): Double {
        return object :Any(){
            var pos=-1
            var ch=0
            fun nextchar(){
                ch=if(++pos<str.length) str[pos].toInt() else -1
            }
            fun eat(charToEdt : Int):Boolean{
                while(ch==' '.toInt())nextchar()

                if(ch==charToEdt){
                    nextchar()
                    return true
                }
                return false
            }
            fun parse():Double{
                nextchar()
                val x=parseexp()
                if(pos<str.length)throw RuntimeException("Error"+ch.toChar())
                return x
            }

            fun parseexp(): Double {
                var x=parseTerm()
                while(true){
                    if(eat('+'.toInt())) x +=parseTerm()
                    else if(eat('-'.toInt())) x -=parseTerm()
                    else return x
                }
            }
            fun parseTerm():Double{
                var x=parseFactor()
                while(true){
                    if(eat('*'.toInt())) x *= parseFactor()
                    else if(eat('/'.toInt())) x /= parseFactor()
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor()
                if (eat('-'.toInt())) return -parseFactor()
                var x:Double
                val startpos=pos
                    if(eat('('.toInt())){
                        x=parse()
                        eat(')'.toInt())
                    }else if(ch>='0'.toInt() && ch<='9'.toInt() || ch=='.'.toInt()){
                        while (ch>='0'.toInt() && ch<='9'.toInt() || ch=='.'.toInt()) nextchar()

                        x=str.substring(startpos,pos).toDouble()
                    }else if(ch>='a'.toInt() && ch<='z'.toInt()){
                        while(ch>='a'.toInt() && ch<='z'.toInt()) nextchar()
                        val func=str.substring(startpos,pos)
                        x=parseFactor()
                        if(func=="sqrt"){
                            x=Math.sqrt(x)
                        }
                        else if(func=="sin"){
                            x=Math.sin(Math.toRadians(x))
                        }else if(func=="cos"){
                            x=Math.cos(Math.toRadians(x))
                        }else if(func=="tan"){
                            x=Math.tan(Math.toRadians(x))
                        }else if(func=="log"){
                            x=Math.log10(x)
                        }else if(func=="ln"){
                            x=Math.log(x)
                        }else if(func=="e"){
                            x=Math.exp(x)
                        }
                    }else{
                        throw RuntimeException("UnExpected: "+ch.toChar())
                    }
                    if(eat('^'.toInt())) x = Math.pow(x,parseFactor())
                    return x
                }
            }.parse()
    }
}
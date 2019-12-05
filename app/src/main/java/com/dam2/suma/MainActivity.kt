package com.dam2.suma

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


const val SUMA_REQUEST = 1
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSumar.setOnClickListener {
            val intent = Intent(this, ActivityDetalle::class.java)
            var num1 = textoA.text
            var num2 = textoB.text
            intent.putExtra("a", Integer.parseInt(num1.toString()))
            intent.putExtra("b", Integer.parseInt(num2.toString()))

            startActivityForResult(intent, SUMA_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if(requestCode == SUMA_REQUEST){
            if (resultCode == Activity.RESULT_OK){
                    sumaTexto.setText(data.getIntExtra("suma", 0).toString())

            }

        }

    }

}

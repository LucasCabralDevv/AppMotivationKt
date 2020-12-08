package com.lucascabral.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        splashSaveButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        val id = view.id
        if (id == R.id.splashSaveButton) {
            handleSave()
        }
    }

    private fun handleSave() {

        val name = splashNameEdit.text.toString()
        if (name.isNotEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(
                this,
                "Por favor, preencha o campo nome!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
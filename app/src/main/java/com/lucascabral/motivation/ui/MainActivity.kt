package com.lucascabral.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucascabral.motivation.R
import com.lucascabral.motivation.infra.MotivationConstants
import com.lucascabral.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)

        mainNameTextView.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
    }
}
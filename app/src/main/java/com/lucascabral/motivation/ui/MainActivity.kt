package com.lucascabral.motivation.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lucascabral.motivation.R
import com.lucascabral.motivation.infra.MotivationConstants
import com.lucascabral.motivation.infra.SecurityPreferences
import com.lucascabral.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        //Lógica inicial
        mainAllImageView.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewPhrase()

        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        mainNameTextView.text = "Hello, $name"

        mainNewPhraseButton.setOnClickListener(this)
        mainAllImageView.setOnClickListener(this)
        mainHappyImageView.setOnClickListener(this)
        mainMorningImageView.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        val id = view.id

        val listFilter =
            listOf(R.id.mainAllImageView, R.id.mainHappyImageView, R.id.mainMorningImageView)

        if (id == R.id.mainNewPhraseButton) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

        mainAllImageView.setColorFilter(resources.getColor(R.color.white))
        mainHappyImageView.setColorFilter(resources.getColor(R.color.white))
        mainMorningImageView.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            R.id.mainAllImageView -> {
                mainAllImageView.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.mainHappyImageView -> {
                mainHappyImageView.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.mainMorningImageView -> {
                mainMorningImageView.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }
    }

    private fun handleNewPhrase() {

        mainPhraseTextView.text = Mock().getPhrase(mPhraseFilter)
    }
}
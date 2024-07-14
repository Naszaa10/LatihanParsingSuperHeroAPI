package com.nasza.latihanparsingsuperheroapi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.nasza.latihanparsingsuperheroapi.model.MainViewModel
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvIntel = findViewById<TextView>(R.id.tvIntel)
        val tvStrength = findViewById<TextView>(R.id.tvStrength)
        val tvSpeed = findViewById<TextView>(R.id.tvSpeed)
        val tvDurability = findViewById<TextView>(R.id.tvDurability)
        val tvPower = findViewById<TextView>(R.id.tvPower)
        val tvCombat = findViewById<TextView>(R.id.tvCombat)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvFullName = findViewById<TextView>(R.id.tvFullName)
        val tvPlaceOfBirth = findViewById<TextView>(R.id.tvPlaceOfBirth)
        val tvFirstAppearance = findViewById<TextView>(R.id.tvFirstAppearance)
        val tvPublisher = findViewById<TextView>(R.id.tvPublisher)
        val ivSuperHero = findViewById<ImageView>(R.id.ivSuperHero)

        val tvGender = findViewById<TextView>(R.id.tvGender)
        val tvRace = findViewById<TextView>(R.id.tvRace)
        val tvHeight = findViewById<TextView>(R.id.tvHeight)
        val tvWeight = findViewById<TextView>(R.id.tvWeight)
        val tvEyeColor = findViewById<TextView>(R.id.tvEyeColor)
        val tvHairColor = findViewById<TextView>(R.id.tvHairColor)

        val tvOccupation = findViewById<TextView>(R.id.tvOccupation)
        val tvBase = findViewById<TextView>(R.id.tvBase)

        val tvGroupAffiliation = findViewById<TextView>(R.id.tvGroupAffiliation)
        val tvRelatives = findViewById<TextView>(R.id.tvRelatives)

        viewModel.superHero.observe(this, Observer { superHero ->
            superHero?.let {
                tvIntel.text = it.powerstats?.intelligence ?: "N/A"
                tvStrength.text = it.powerstats?.strength ?: "N/A"
                tvSpeed.text = it.powerstats?.speed ?: "N/A"
                tvDurability.text = it.powerstats?.durability ?: "N/A"
                tvPower.text = it.powerstats?.power ?: "N/A"
                tvCombat.text = it.powerstats?.combat ?: "N/A"

                tvName.text = it.name ?: "N/A"
                tvFullName.text = it.biography?.fullName ?: "N/A"
                tvPlaceOfBirth.text = it.biography?.placeOfBirth ?: "N/A"
                tvFirstAppearance.text = it.biography?.firstAppearance ?: "N/A"
                tvPublisher.text = it.biography?.publisher ?: "N/A"

                tvGender.text = it.appearance?.gender ?: "N/A"
                tvRace.text = it.appearance?.race ?: "N/A"
                tvHeight.text = it.appearance?.height?.joinToString(", ") ?: "N/A"
                tvWeight.text = it.appearance?.weight?.joinToString(", ") ?: "N/A"
                tvEyeColor.text = it.appearance?.eyeColor ?: "N/A"
                tvHairColor.text = it.appearance?.hairColor ?: "N/A"

                tvOccupation.text = it.work?.occupation ?: "N/A"
                tvBase.text = it.work?.base ?: "N/A"

                tvGroupAffiliation.text = it.connections?.groupAffiliation ?: "N/A"
                tvRelatives.text = it.connections?.relatives ?: "N/A"

                val imageUrl = it.image?.url ?: ""
                if (imageUrl.isNotEmpty()) {
                    Glide.with(this)
                        .load(imageUrl)
                        .into(ivSuperHero)
                } else {
                    ivSuperHero.setImageResource(R.drawable.ic_hehe)
                }
            } ?: run {
                Toast.makeText(this, "Failed to load superhero data", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.error.observe(this, Observer { errorMessage ->
            if (errorMessage != null) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
}


package com.example.travelbuddy

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.example.travelbuddy.databinding.ActivityDetailBinding

/**
 * Screen 2: shows the full details of the destination that was tapped in the list.
 * Also demonstrates two implicit Intents: ACTION_SEND (share) and ACTION_VIEW (open link).
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var destination: Destination
    private var isFavourite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Read the extra that MainActivity put into the Intent.
        // The Intent is still available after rotation, so the same item is shown again.
        val received = IntentCompat.getParcelableExtra(
            intent, EXTRA_DESTINATION, Destination::class.java
        )
        if (received == null) {
            Toast.makeText(this, R.string.error_no_destination, Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        destination = received

        isFavourite = savedInstanceState?.getBoolean(STATE_FAVOURITE) ?: false

        bindDestination()
        setupButtons()
        updateFavouriteButton()
    }

    private fun bindDestination() {
        title = destination.name
        binding.emojiText.text = destination.emoji
        binding.nameText.text = destination.name
        binding.countryText.text = destination.country
        binding.taglineText.text = destination.tagline
        binding.ratingText.text = getString(R.string.rating_format, destination.rating)
        binding.seasonValue.text = destination.bestSeason
        binding.budgetValue.text = destination.budget
        binding.descriptionText.text = destination.description
    }

    private fun setupButtons() {
        binding.shareButton.setOnClickListener { shareDestination() }
        binding.webButton.setOnClickListener { openWebPage() }
        binding.favouriteButton.setOnClickListener {
            isFavourite = !isFavourite
            updateFavouriteButton()
        }
    }

    private fun updateFavouriteButton() {
        binding.favouriteButton.setText(
            if (isFavourite) R.string.favourite_remove else R.string.favourite_add
        )
    }

    /** Implicit Intent #1: ACTION_SEND lets the user share text through any installed app. */
    private fun shareDestination() {
        val message = getString(
            R.string.share_text_format,
            destination.name,
            destination.country,
            destination.tagline,
            destination.webUrl
        )
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, destination.name)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        startActivity(Intent.createChooser(sendIntent, getString(R.string.share_chooser_title)))
    }

    /** Implicit Intent #2: ACTION_VIEW opens the destination's web page in a browser. */
    private fun openWebPage() {
        val viewIntent = Intent(Intent.ACTION_VIEW, Uri.parse(destination.webUrl))
        try {
            startActivity(viewIntent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.error_no_app, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_FAVOURITE, isFavourite)
    }

    // The action bar "up" arrow behaves like the back button
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EXTRA_DESTINATION = "extra_destination"
        private const val STATE_FAVOURITE = "state_favourite"
    }
}

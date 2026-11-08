package com.example.travelbuddy

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelbuddy.databinding.ActivityAboutBinding

/**
 * Screen 3: a simple About page with two more implicit Intents (ACTION_DIAL and ACTION_SENDTO).
 */
class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.callButton.setOnClickListener { dialSupport() }
        binding.emailButton.setOnClickListener { emailFeedback() }
    }

    /** ACTION_DIAL opens the dialer with the number filled in; no CALL_PHONE permission needed. */
    private fun dialSupport() {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.support_phone)))
        launchSafely(intent)
    }

    /** ACTION_SENDTO with a mailto: URI only matches email apps. */
    private fun emailFeedback() {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse(getString(R.string.support_email))).apply {
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.feedback_subject))
        }
        launchSafely(intent)
    }

    private fun launchSafely(intent: Intent) {
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.error_no_app, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}

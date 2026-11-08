package com.example.travelbuddy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.travelbuddy.databinding.ActivityMainBinding

/**
 * Screen 1: shows the list of destinations in a RecyclerView.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Name of the last destination the user opened. Kept across rotation (see onSaveInstanceState).
    private var lastViewed: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Restore state after rotation / process recreation
        lastViewed = savedInstanceState?.getString(STATE_LAST_VIEWED)

        setupRecyclerView()
        showLastViewed()
    }

    private fun setupRecyclerView() {
        val spanCount = resources.getInteger(R.integer.list_span_count)
        binding.recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        binding.recyclerView.adapter = DestinationAdapter(DestinationRepository.destinations) { destination ->
            openDetail(destination)
        }
    }

    /** Explicit Intent: start DetailActivity and pass the tapped item as an extra. */
    private fun openDetail(destination: Destination) {
        lastViewed = destination.name
        showLastViewed()

        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_DESTINATION, destination)
        }
        startActivity(intent)
    }

    private fun showLastViewed() {
        val name = lastViewed
        binding.lastViewedText.text = if (name == null) {
            getString(R.string.last_viewed_none)
        } else {
            getString(R.string.last_viewed_format, name)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_LAST_VIEWED, lastViewed)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                // Explicit Intent to the third Activity
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        private const val STATE_LAST_VIEWED = "state_last_viewed"
    }
}

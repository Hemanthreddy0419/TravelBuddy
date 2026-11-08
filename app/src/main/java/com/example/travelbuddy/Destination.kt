package com.example.travelbuddy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A single travel destination.
 *
 * Implements [Parcelable] (via the kotlin-parcelize plugin) so that a whole
 * object can be passed from the list screen to the detail screen inside an Intent extra.
 */
@Parcelize
data class Destination(
    val id: Int,
    val name: String,
    val country: String,
    val emoji: String,
    val tagline: String,
    val description: String,
    val bestSeason: String,
    val budget: String,
    val rating: Float,
    val wikiTitle: String
) : Parcelable {

    /** Link used by the "Read more" implicit ACTION_VIEW intent. */
    val webUrl: String
        get() = "https://en.wikipedia.org/wiki/$wikiTitle"
}

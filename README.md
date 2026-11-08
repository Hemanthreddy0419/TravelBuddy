# TravelBuddy

A small native Android app (Kotlin + ViewBinding) that shows a list of travel destinations,
opens a detail page for the one you tap, and has an About screen. It was built to practise
Activities, Intents and RecyclerView.

## Features

| Requirement | Where it is implemented |
|---|---|
| 3 Activities with explicit Intents | `MainActivity` → `DetailActivity` (tap an item), `MainActivity` → `AboutActivity` (overflow menu) |
| Real data passed via Intent extras | `MainActivity.openDetail()` puts a `Parcelable` `Destination` into the Intent; `DetailActivity` reads it with `IntentCompat.getParcelableExtra()` |
| Implicit Intents | Share (`ACTION_SEND`) and Read more (`ACTION_VIEW`) in `DetailActivity`; Call support (`ACTION_DIAL`) and Send feedback (`ACTION_SENDTO`) in `AboutActivity` |
| RecyclerView + custom Adapter/ViewHolder, 10+ items | `DestinationAdapter`, `item_destination.xml`, 12 items in `DestinationRepository` |
| Tap opens that specific item | The adapter passes the item bound at that row to the click callback |
| Survives rotation | The detail data comes from the Intent (re-delivered after rotation); "last viewed" and the favourite toggle are kept in `onSaveInstanceState`; landscape uses a 2-column grid |

## Project structure

```
app/src/main/java/com/example/travelbuddy/
  Destination.kt            data class + Parcelable
  DestinationRepository.kt  12 mock destinations
  DestinationAdapter.kt     RecyclerView.Adapter + ViewHolder
  MainActivity.kt           list screen
  DetailActivity.kt         detail screen (share / open link / favourite)
  AboutActivity.kt          about screen (dial / email)
```

## Build and run

1. Install Android Studio (a recent version) and open this folder with **File > Open**.
2. Let Gradle sync finish (JDK 17 is bundled with Android Studio).
3. Pick an emulator or a connected phone and press **Run**.

Android Studio uses the Gradle version from `gradle/wrapper/gradle-wrapper.properties` (8.9),
so no extra setup is needed.

Requirements: minSdk 24, compileSdk/targetSdk 35.

## Try it

1. Scroll the list and tap any destination. The detail page shows that item.
2. Tap **Share** to open the system share sheet, **Read more** to open Wikipedia.
3. Rotate the device: the same destination stays on screen, and the list keeps its position.
4. Go back, open the overflow menu (three dots) and choose **About**, then try **Call support**.

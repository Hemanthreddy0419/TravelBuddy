TravelBuddy

TravelBuddy is a small Android app I built to practise the basics of Android development: Activities, Intents and RecyclerView. It shows a list of travel destinations, lets you tap one to read about it, and has a simple About page.
Built with Kotlin and ViewBinding.

What the app does :
Browse a scrolling list of 12 famous destinations (Kyoto, Santorini, Paris and more).
Tap any destination to see its full details: country, rating, best season, budget and a short description.
Share a destination with friends, or open its Wikipedia page.
Save a destination as a favourite on its detail page.
About page with buttons to call support or send feedback by email.

How it meets the project requirements :  
Requirement	How it is done
At least 3 Activities with explicit Intents	MainActivity opens DetailActivity when you tap an item, and AboutActivity from the three-dot menu.
Real data passed through Intent extras	The tapped Destination is sent to DetailActivity as a Parcelable extra.
At least one implicit Intent	Share (ACTION_SEND), Read more (ACTION_VIEW), Call support (ACTION_DIAL) and Send feedback (ACTION_SENDTO).
RecyclerView with custom Adapter and ViewHolder, 10+ items	DestinationAdapter with its ViewHolder shows 12 destinations.
Tapping an item shows that item’s data	Each row passes its own item to the detail screen, so the right destination always opens.
Survives screen rotation	The detail screen reads its data from the Intent again after rotating. The “last viewed” text and the favourite button are saved with onSaveInstanceState. In landscape the list switches to two columns.

Project structure
app/src/main/java/com/example/travelbuddy/
├── Destination.kt             Data class (Parcelable) for one destination
├── DestinationRepository.kt   The 12 hardcoded destinations
├── DestinationAdapter.kt      RecyclerView Adapter and ViewHolder
├── MainActivity.kt            List screen
├── DetailActivity.kt          Detail screen (share, open link, favourite)
└── AboutActivity.kt           About screen (call, email)

How to run it :
Install a recent version of Android Studio. It comes with the JDK and Android SDK.
Clone this repository, then in Android Studio choose File > Open and select the project folder.
Wait for Gradle to finish syncing.
Choose an emulator or a connected phone and press Run.
Requirements: minSdk 24, compileSdk and targetSdk 35, Gradle 8.9.

What I learned :
Moving between screens with explicit Intents and passing data with extras
Using implicit Intents to hand work to other apps
Building a list with a custom RecyclerView Adapter and ViewHolder
Keeping UI state across screen rotation

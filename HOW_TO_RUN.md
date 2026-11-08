# Run TravelBuddy on Windows

## Option 1: Android Studio (recommended)

1. Extract `TravelBuddy.zip` to a folder you can find, such as `Documents/AndroidProjects`.
2. Open Android Studio and choose **Open**.
3. Select the extracted `TravelBuddy` folder (the folder containing `settings.gradle.kts`).
4. If prompted, allow Gradle sync to finish. Use JDK 17; Android Studio's bundled JDK is suitable.
5. Create or select an Android emulator in **Device Manager**, or connect an Android phone with USB debugging enabled.
6. Select that device in the top toolbar and click **Run ▶**.
7. On the home screen, tap any destination. Use **Share** or **Read more** to try the implicit intents. Use the overflow menu and choose **About** to open the third screen.

The first sync downloads Gradle and Android dependencies, so it needs an internet connection. Android SDK Platform 35 may be installed by Android Studio if prompted.

## Option 2: Build from PowerShell

1. Install Android Studio (for the Android SDK) and a JDK 17.
2. Extract the ZIP and open PowerShell in the extracted `TravelBuddy` folder.
3. Build the debug APK:

   ```powershell
   .\gradlew.bat assembleDebug
   ```

4. To install it on a connected device or running emulator:

   ```powershell
   .\gradlew.bat installDebug
   ```

The APK is created at `app\build\outputs\apk\debug\app-debug.apk`.

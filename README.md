# Marvel API Test

## Prerequisites
Before you begin, please review the following prerequisites and documentation: https://developer.marvel.com/documentation/authorization

Set the keys for consuming the Marvel API in Constants.kt
* Add the BASE_URL, hash, ts and public key to use the app.
```kotlin
    const val PUBLIC_CREDENTIALS = ""
    const val HASH = ""
    const val TS = ""
    const val ORDER = "title"
    const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
```

## Dependencies

* Dependencies on gradle.build file.
```kotlin
    // Kotlin and Android dependencies
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    // Life cycle and architecture components dependencies
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1'
    implementation 'androidx.fragment:fragment-ktx:1.5.0-alpha03'
    implementation 'androidx.core:core-splashscreen:1.0.0-beta01'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2'
    // View and design dependencies
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    implementation 'com.squareup.picasso:picasso:2.71828'
    implementation 'com.github.ybq:Android-SpinKit:1.4.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    // API petitions dependencies
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    // Testing dependencies
    testImplementation 'junit:junit:4.+'
    testImplementation 'com.google.truth:truth:1.1.3'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'com.google.truth:truth:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
```

## App Instalation
To install the app please download the apk file in ./apk:

## Testing
In the class UtilTest you can find two basic unit tests using Google Truth, testing a url formatter method

```kotlin
    @Test
    fun getCorrectImageURLTest() {
        val imagePath = "http://i.annihil.us/u/prod/marvel/i/mg/8/04/58e69de9d1fed"
        val correctPath = "https://i.annihil.us/u/prod/marvel/i/mg/8/04/58e69de9d1fed.jpg"
        val imageExtension = "jpg"
        val result = getCorrectImageURL(imagePath, imageExtension)
        assertThat(result).containsMatch(correctPath)
    }

    @Test
    fun getIncorrectImageURLTest() {
        val imagePath = "http://i.annihil.us/u/prod/marvel/i/mg/8/04/58e69de9d1fed"
        val correctPath = "https://i.annihil.us/u/prod/marvel/i/mg/8/04/58e69de9d1fed.jpg"
        val imageExtension = ".jpg"
        val result = getCorrectImageURL(imagePath, imageExtension)
        assertThat(result).doesNotContainMatch(correctPath)
    }
```

## User Experience
![marveltest](marveltest.jpg)
![marveltest1](marveltest1.jpg)

## Legal
The use of the API and any related documentation is governed by and must be used in accordance with the Terms and Conditions of Use of © 2022 MARVEL, which may be found at: https://developer.marvel.com/.
The application code and usage rights also belong to David Antonio Moreno.

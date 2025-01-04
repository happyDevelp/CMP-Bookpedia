This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.
This application was developed during the Compose Multiplatform course.


# CMP-Bookpedia

Welcome to the Bookpedia app, designed to help you find books and basic information about them

<img src="https://github.com/happyDevelp/CMP-Bookpedia/blob/master/readme/screenshots/BookListScreen.jpg" width="170" height="350">


## Overview

By entering the title of any book, a request is made to the Internet (using REST API)

## Features

• Searching  books on the Internet.

• View detailed information about a book by clicking on it. For example, rating, number of pages, languages in which the book is available and a short description

• Ability to save a book to favorites using databases to access it even without the Internet

• Ability to save a book to favorites using databases to access it even without the Internet

• Thanks to compose multiplatform the application can be used for android iphone and computer

## How to Use

1. Launch the App: Start your journey by opening the Habit Tracker app.

2. Search a book: Enter the desired book title in the search bar.

3. Detailed information: From the list of suggested books, click on one of them and you will see additional information about this book.

4. Favorites: Want to save a book on your device? No problem. Add it to your favorites, and it will be with you even without an internet connection.

## Screenshots

*Demonstration of the application*

<img src="https://github.com/happyDevelp/CMP-Bookpedia/blob/master/readme/screenshots/app_demo.gif" width="250" height="550">



*Book list screen*

<img src="https://github.com/happyDevelp/CMP-Bookpedia/blob/master/readme/screenshots/BookListScreen.jpg" width="250" height="550">



*Book list screen on Windows*

<img src="https://github.com/happyDevelp/CMP-Bookpedia/blob/master/readme/screenshots/Book_list(pc_version).png" width="650" height="550">



*Book detail screen*

<img src="https://github.com/happyDevelp/CMP-Bookpedia/blob/master/readme/screenshots/DetailBookScreen.jpg" width="250" height="550">



*Book detail screen on Windows*

<img src="https://github.com/happyDevelp/CMP-Bookpedia/blob/master/readme/screenshots/Book_detail(pc_version).png" width="700" height="620">



*Favorites*

<img src="https://github.com/happyDevelp/CMP-Bookpedia/blob/master/readme/screenshots/Favorite.jpg" width="250" height="550">






## Technologies Used

- Kotlin
- Compose Multiplatform (Android, IOS, PC)
- MVI architecture
- Rest API (Internet query)
- Ktor 3.0
- Coil (image loading libraries)
- Koin DI (Dependency Injection)
- Kotlin Coroutines
- Room Database


## Installation

1. Clone the repository.
2. Open the project in Android Studio.
3. Run the app on an emulator or physical device.


## Additional information

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

## Important note

### I don't have Apple technology, which means I haven't had the opportunity to run and test the app on iOS, so for iPhone users the app may not work

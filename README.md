# Kotlin_ShoppingList

A simple shopping list app demonstrating the MVVM (Model-View-ViewModel) architecture in Android.

## Screenshots

![image](https://github.com/ho1225/Kotlin_ShoppingList/assets/56968144/227c9697-4191-46d5-9968-7cb629990026)
![image](https://github.com/ho1225/Kotlin_ShoppingList/assets/56968144/d20452fb-b0ea-4135-9041-94491e8f0a7d)


## Features

- Add, edit, and delete shopping list items.
- Mark items as completed.
- Clean and intuitive user interface.
- Architecture follows the MVVM design pattern.
- Written in Kotlin.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Android Studio: [Download here](https://developer.android.com/studio)
- Kotlin Plugin

### Installing

1. Clone the repository:

   git clone https://github.com/ho1225/Kotlin_ShoppingList.git

Open the project in Android Studio.

Build and run the app on an emulator or a physical device.

Architecture
The app follows the MVVM (Model-View-ViewModel) architecture to ensure separation of concerns and maintainability. Key components:

Model: Manages the data and business logic. In this app, it handles the shopping list items and interactions with the data source.  
View: Represents the UI. It observes the ViewModel and updates the UI accordingly.  
ViewModel: Acts as a bridge between the Model and the View. It holds the presentation logic, manages UI-related data, and communicates with the Model. 

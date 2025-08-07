# 📱 Android SQLite Database App

![Android](https://img.shields.io/badge/Platform-Android-green?logo=android)
![Java](https://img.shields.io/badge/Language-Java-blue?logo=java)
![SQLite](https://img.shields.io/badge/Database-SQLite-lightgrey?logo=sqlite)
![License](https://img.shields.io/badge/License-MIT-brightgreen)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

## 📌 About

This is a **basic Android application** built using **Java** that demonstrates how to use **SQLite** for local data storage. The app allows users to enter a username and password, which are saved in a local database upon submission. It’s a simple and effective way to understand **data persistence** on Android without external servers or APIs.

---

## 🚀 Features

- 📥 Takes user input via EditText
- 🗃️ Creates a local SQLite database (`studentdb`)
- 🏗️ Creates a table named `student` if it doesn’t exist
- ➕ Inserts new username and password records
- ✅ Displays a success `Toast` message
- 🔁 Navigates to the next activity (`Home_Page`) after storing data

---

## 🧰 Tech Stack

- **Language:** Java
- **Platform:** Android
- **IDE:** Android Studio
- **Database:** SQLite (built-in)

---

## 📂 Project Structure

```
📦 com.example.dbconnection
 ┣ 📄 MainActivity.java
 ┣ 📄 Home_Page.java
 ┣ 🗂️ res/layout/activity_main.xml
 ┗ 🗂️ AndroidManifest.xml
```

---

## 💻 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   ```

2. Open the project in **Android Studio**.

3. Connect your emulator or Android device.

4. Click **Run** ▶️ to build and launch the app.

---

## ⚠️ Important Notes

- This is a **basic example** and not meant for production use.
- Passwords are stored in plain text — for real applications, use encryption or secure authentication.
- SQL injection protection (e.g., using `SQLiteStatement` or `Room`) is not implemented but recommended for safety.

---

## 📚 Useful Resources

- [SQLite for Android](https://developer.android.com/training/data-storage/sqlite)
- [Android Developer Docs](https://developer.android.com/)
- [Java for Android](https://developer.android.com/courses/java)

---

## 🙌 Contributions

Feel free to fork this repository and add enhancements like:

- 🔒 Input validation
- 🧠 Login authentication
- 💾 Use of Room Database
- 🎨 UI improvements with Material Design

---

> ✨ Learn by building — this simple app is a great starting point for mastering local database handling in Android!

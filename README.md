# 📱 Android SQLite Database CRUD App

![Android](https://img.shields.io/badge/Platform-Android-green?logo=android)
![Java](https://img.shields.io/badge/Language-Java-blue?logo=java)
![SQLite](https://img.shields.io/badge/Database-SQLite-lightgrey?logo=sqlite)
![License](https://img.shields.io/badge/License-MIT-brightgreen)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

## 📌 About

This is a **basic Android application** built using **Java** that demonstrates **CRUD operations** (Create, Read, Update, Delete) with **SQLite** for local data storage. The app allows users to add, view, update, and delete records without needing an internet connection. It’s a simple and effective way to understand **data persistence** in Android.

---

## 🚀 Features

- ➕ **Create**: Add new username and password records
- 📄 **Read**: Display all stored records
- ✏️ **Update**: Edit existing username and password by ID
- ❌ **Delete**: Remove a record by username
- 🗃️ Automatically creates `student` table if it doesn’t exist
- ✅ Displays success and error `Toast` messages
- 🔄 Activity navigation for each operation

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
 ┣ 📄 MainActivity.java          # Create records
 ┣ 📄 Home_Page.java             # Read & Delete records
 ┣ 📄 Update_Page.java           # Update records
 ┣ 🗂️ res/layout/activity_main.xml
 ┣ 🗂️ res/layout/activity_home.xml
 ┣ 🗂️ res/layout/activity_update.xml
 ┗ 📄 AndroidManifest.xml
```

---

## 💻 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/harinandanmv/android-db-connection.git
   ```
2. Open in **Android Studio**  
3. Connect emulator or Android device  
4. Click **Run** ▶️ to build and launch the app

---

## ⚠️ Important Notes

- Passwords are stored in **plain text** — use encryption for production apps
- SQL queries are vulnerable to **SQL injection** — use `SQLiteStatement` or **Room**
- This is for **educational purposes only**

---

## 📚 Useful Resources

- [SQLite for Android](https://developer.android.com/training/data-storage/sqlite)
- [Android Developer Docs](https://developer.android.com/)
- [Java for Android](https://developer.android.com/courses/java)

---

## 🙌 Contributions

You can improve this app by adding:
- 🔒 Input validation
- 🧠 Login authentication
- 💾 Migration to Room Database
- 🎨 Material Design UI improvements

---

> ✨ Learn by building — this CRUD app is a great starting point to master SQLite in Android!

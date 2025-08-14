# LIBRARY-MANAGEMENT-SYSTEM

A fully functional command-line application for library management, developed in Java. It demonstrates core software development principles, including Object-Oriented Programming (OOP) for modeling books and members, the Collections Framework for data management, and File I/O for data persistence, ensuring no information is lost between sessions.

---

## 📋 Project Description

This project is a **command-line based Library Management System** created entirely in Java. It serves as a practical demonstration of fundamental programming concepts, including Object-Oriented Programming, data structures, and file handling. The system allows a librarian to perform essential daily tasks such as adding new books, registering library members, and processing book check-outs and returns, all through a simple and intuitive terminal interface.

The primary goal of this project was to apply theoretical Java knowledge to a real-world scenario, focusing on creating clean, modular, and maintainable code.

---

## ✨ Key Features

* **Book Management**: Add new books with details like ISBN, title, and author.
* **Member Management**: Register new library members with a system-generated unique ID.
* **Lending System**: Securely check books out to members and handle their return, updating availability status in real-time.
* **Data Persistence**: All library data (books and members) is automatically saved to a local `library.dat` file upon exiting the application and is reloaded at startup.
* **View Records**: Display comprehensive lists of all books (with their current status) and all registered members.
* **Object-Oriented Design**: The system is built using clean, Object-Oriented principles (`Book`, `Member`, `Library` classes), making it scalable and easy to understand.

---

## 🛠️ Technologies Used

* **Core Language**: **Java**
* **Key APIs**:
    * **Java Collections Framework**: `ArrayList` for dynamic storage of book and member objects.
    * **Java I/O (Input/Output)**: `FileOutputStream`, `FileInputStream`, `ObjectOutputStream`, and `ObjectInputStream` for object serialization to save and load application state.
    * **Util Package**: `Scanner` for handling user input and `UUID` for generating unique member IDs.

---

## 🚀 How to Run Locally

To compile and run this project on your local machine, follow these steps:

1.  **Prerequisites**:
    * Make sure you have **Java Development Kit (JDK)** installed (version 8 or higher).

2.  **Clone the Repository**:
    ```sh
    git clone [https://github.com/kinshukkush/LIBRARY-MANAGEMENT-SYSTEM.git](https://github.com/kinshukkush/LIBRARY-MANAGEMENT-SYSTEM.git)
    ```

3.  **Navigate to the Directory**:
    ```sh
    cd LIBRARY-MANAGEMENT-SYSTEM
    ```

4.  **Compile the Java Files**:
    Open your terminal in the project directory and run the `javac` compiler.
    ```sh
    javac *.java
    ```
    This will create the necessary `.class` files.

5.  **Run the Application**:
    Execute the `main` method in the `Main` class.
    ```sh
    java Main
    ```
    The application will start, and you can begin using the library management system. A `library.dat` file will be created in the same directory to store data.

---

## 📂 File Structure

The project is organized into the following source files:

* `Book.java`: Defines the `Book` object, containing properties like ISBN, title, author, and availability status.
* `Member.java`: Defines the `Member` object with properties for member ID and name.
* `Library.java`: The core class that contains all the business logic for managing the collections of books and members, handling check-outs/returns, and saving/loading data.
* `Main.java`: The main entry point for the application. It contains the user interface loop and handles all user interactions.
* `.gitignore`: Specifies which files (like `.class` and `.dat`) should be ignored by Git.

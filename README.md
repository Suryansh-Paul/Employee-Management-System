# Employee Management System (Java + JDBC + MySQL)

## 📖 Overview

This is a Java-based Employee Management System built as a learning project to understand Core Java, JDBC, and MySQL database integration.

The project demonstrates basic CRUD (Create, Read, Update, Delete) operations using Java and MySQL.

It also includes a simple Swing-based GUI (generated using AI) for UI representation, while the core backend logic is implemented in Java.

---

## 🎯 Purpose of Project

This project was created as part of my learning journey in Java backend development to strengthen:

- Core Java fundamentals
- Object-Oriented Programming (OOP)
- JDBC (Java Database Connectivity)
- SQL and MySQL integration
- Basic project structuring

---

## ⚙️ Features

- Add new employee
- View all employees
- Update employee details
- Delete employee records
- MySQL database integration
- Console-based application (primary interface)
- Basic Swing GUI (AI-assisted for UI layout)

---

## 🧱 Tech Stack

- Java (Core Java)
- JDBC
- MySQL
- Swing (AI-assisted UI)
- IntelliJ IDEA

---

## 📁 Project Structure

- `employee.java` → Model class representing Employee entity
- `employee_dao.java` → Handles all database operations (CRUD)
- `db_connection.java` → Manages MySQL database connection
- `Main.java` → Console-based application (primary implementation written by me)
- `GUI.java` → Swing-based UI (AI-assisted for layout and design)

---

## 🧠 My Contribution

- Designed and implemented full backend logic using Java
- Built all JDBC CRUD operations manually
- Created console-based application for user interaction
- Designed database schema and queries
- Understood and implemented Java–MySQL integration

---

## 🤖 AI Usage Disclosure

- The Swing GUI interface was generated using AI tools for learning and experimentation purposes.
- I do not claim expertise in Swing GUI development.
- The focus of this project is backend logic and database connectivity.

---

## 🗄️ Database Setup

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Age INT,
    Branch VARCHAR(100),
    Salary DOUBLE
);
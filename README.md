# JAVA-LAB-ASSIGNMENT-3
 Project Overview

This Student Management System is a console-based Java program designed to manage student data efficiently while ensuring robustness, responsiveness, and data validation.
It utilizes:

Exception Handling for safe input operations

Multithreading to simulate a loading process

Wrapper Classes (Integer, Double) for data type conversion and autoboxing

 Objectives

The main goals of this project are:

To handle runtime errors gracefully using try-catch-finally blocks

To simulate responsiveness using Threads

To demonstrate autoboxing with wrapper classes like Integer and Double

 Class Hierarchy
Class	Description
Main	Entry point of the program. Displays menu and handles user choices.
Student	Represents a student with details like roll number, name, email, course, marks, and grade.
StudentManager	Implements the logic to add and display students with proper validation and exception handling.
Loader	Implements Runnable to simulate a loading animation using multithreading.
StudentNotFoundException	Custom exception class for handling missing student records.
RecordActions	Interface defining standard methods for record management.
 Features

Add new student records with input validation
 View student details using roll number
 Handle invalid input (e.g., marks > 100, empty fields)
 Simulate data loading using multithreading
 Use of custom exceptions for robust error handling
 Clean, menu-driven user interface

 Concepts Used

Exception Handling:
Uses try-catch-finally blocks for safe execution and error handling.

Multithreading:
A separate thread (Loader) simulates a loading animation using Thread.sleep().

Wrapper Classes:
Demonstrates the use of Integer and Double (autoboxing & unboxing).

Custom Exceptions:
StudentNotFoundException handles missing student records gracefully.

 Program Flow
 Student Management System 
1. Add Student
2. View Student
3. Exit
Enter your choice:


If you choose Add Student, the program will:

Accept student details

Validate fields

Simulate a loading process using threading

Display confirmation

If you choose View Student, the program will:

Ask for a roll number

Display student details if found

Throw StudentNotFoundException if the record doesn’t exist

 Example Output
 Adding a Student
Enter Roll No (Integer): 101
Enter Name: Radhika
Enter Email: radhika@mail.com
Enter Course: BCA
Enter Marks: 85.5
Loading.....
.....Loading complete!

Student added successfully!
Operation completed.

 Viewing a Student
Enter Roll No to View: 101
Roll No: 101
Name: Radhika
Email: radhika@mail.com
Course: BCA
Marks: 85.5
Grade: B
# D24 Hostel Management System

![Java](https://img.shields.io/badge/Java-17-orange) ![GitHub](https://img.shields.io/github/license/DewmithMihisara/d24-hostel)

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
  - [Installation](#installation)
  - [Usage](#usage)
- [CRUD Operations](#crud-operations)
  - [Managing Students](#managing-students)
  - [Managing Rooms](#managing-rooms)
- [Cascade Types](#cascade-types)
- [Viewing Student Details for Room Reservations](#viewing-student-details-for-room-reservations)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction
The D24 Hostel Student Registration and Room Management System is designed to streamline the process of registering students for hostel accommodation and managing room reservations. This system eliminates manual record-keeping, enhances data accuracy, and provides a user-friendly interface for both administrators and students.

## Features
- Create, read, update, and delete (CRUD) operations for students and rooms.
- Cascade types to manage related entities efficiently.
- View student details associated with room reservations.
- Secure and scalable web-based or mobile application.

## Technologies Used
- Java
- JavaFX
- MySQL
- Hibernate

## Architecture
The system follows a layered architecture consisting of the following layers:

- Presentation Layer (JavaFX UI)
- Application Layer (Business Logic)
- Persistence Layer (Database Interaction)
  
## Getting Started

### Installation
1. **Clone the Repository:** Clone the repository to your local machine using Git.
   ```bash
   git clone https://github.com/yourusername/d24-hostel-management.git
   
2. Database Setup:
- Create a MySQL database for the application.
* Configure the Hibernate configuration file (`hibernate.cfg.xml`) with the appropriate database connection details.

3. Build the Project:
Build the project using your preferred Java build tool (e.g., Gradle or Maven).

- Example for Gradle `./gradlew build`

4. Run the Application:
Start the application to launch the user interface.

- Example for Gradle `./gradlew run`

### Usage

#### Logging In
1. Launch the application.

2. You will be presented with a login screen.

3. **Admin User:**
   - Username: `admin`
   - Password: `adminpassword`

#### Dashboard
1. After logging in, you will be directed to the dashboard.

2. **Admin Dashboard:**
   - Admin users have access to the following features:
     - **Manage Students:** Add, edit, and delete student records.
     - **Manage Rooms:** Add, edit, and delete room records.
     - **View Student Details:** Click on a room reservation to view the student's details.

#### Managing Students
- **Admin Users:**
   1. Click on the "Manage Students" option in the dashboard.
   2. Add a new student:
      - Fill in the student's details.
      - Click the "Add" button.
   3. Edit a student's details:
      - Select a student from the list.
      - Click the "Edit" button.
      - Update the details.
      - Click the "Save" button.
   4. Delete a student:
      - Select a student from the list.
      - Click the "Delete" button.

#### Managing Rooms
- **Admin Users:**
   1. Click on the "Manage Rooms" option in the dashboard.
   2. Add a new room:
      - Fill in the room details.
      - Click the "Add" button.
   3. Edit a room's details:
      - Select a room from the list.
      - Click the "Edit" button.
      - Update the details.
      - Click the "Save" button.
   4. Delete a room:
      - Select a room from the list.
      - Click the "Delete" button.

#### Viewing Student Details for Room Reservations
- **Admin Users:**
   1. Click on a room reservation in the dashboard to view the student's details.

#### Logout
- To logout, simply close the application or use the provided logout option.

## CRUD Operations

### Managing Students
- **Create:** Add new student records with personal details, campus student ID, and registration information.
- **Read:** Retrieve and display student details, including room reservations.
- **Update:** Modify student information, contact details, and registration details.
- **Delete:** Remove student records from the system.

### Managing Rooms
- **Create:** Add new rooms with details such as room type, availability status, and room number.
- **Read:** View room details, check availability, and see student reservations.
- **Update:** Update room information, including availability status and room type.
- **Delete:** Remove rooms from the system when necessary.

## Cascade Types
- **CascadeType.REMOVE:** When a student record is deleted, associated room reservations are also removed.
- **CascadeType.MERGE:** Updating a student's information also updates related room reservation records.
- **CascadeType.PERSIST:** Creating a new student and room reservation ensures both records are saved.

## Viewing Student Details for Room Reservations
- Authorized users can view student details associated with specific room reservations.

## License
[Specify the project's license and include any necessary disclaimers or notices.]

## Contact

You can contact me via:

* Email : mihisaralokuhewage@gmail.com
* LinkedIn : [https://linkedin.com/in/dewmith-mihisara-67861a202](https://linkedin.com/in/dewmith-mihisara-67861a202)
* Twitter : [https://twitter.com/Zyne_Galata](https://twitter.com/Zyne_Galata)

  ***
<div align="center">
  
![repo size](https://img.shields.io/github/repo-size/DewmithMihisara/d24-hostel?label=Repo%20Size&style=for-the-badge&labelColor=black&color=20bf6b)
![GitHub stars](https://img.shields.io/github/stars/DewmithMihisara/d24-hostel?&labelColor=black&color=f7b731&style=for-the-badge)
![GitHub LastCommit](https://img.shields.io/github/last-commit/DewmithMihisara/d24-hostel?logo=github&labelColor=black&color=d1d8e0&style=for-the-badge)

</div>

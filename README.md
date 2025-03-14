# Mountain Hiking Challenge Registration System

## Overview

This Java application manages registrations for a Mountain Hiking Challenge. It allows administrators to register students, update their information, display registered participants, search for specific participants, and generate statistics.

## Features

- **Student Registration**: Register new students with validation for ID, name, phone, email, and mountain selection
- **Update Information**: Modify existing student registration details
- **Display Registered List**: View all registered participants in a formatted table
- **Delete Registration**: Remove student registrations from the system
- **Search Functionality**: Find participants by name
- **Filter by Campus**: Filter registrations by campus code (CE, DE, HE, SE, QE)
- **Statistics**: View registration statistics by mountain location
- **Data Persistence**: Save and load registration data to/from files

## System Requirements

- Java 8 or higher
- Maven for dependency management

## Installation and Setup

1. Clone the repository:

   ```
   git clone https://github.com/yourusername/MountainHiking.git
   ```

2. Navigate to the project directory:

   ```
   cd MountainHiking
   ```

3. Build the project with Maven:

   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn exec:java
   ```

## Usage

The application presents a menu-driven interface with the following options:

1. **New Registration**: Register a new student for the hiking challenge
2. **Update Registration**: Modify existing registration information
3. **Display Registered List**: View all registered participants
4. **Delete Registration**: Remove a student from the registration list
5. **Search by Name**: Find participants by name
6. **Filter by Campus**: View registrations from a specific campus
7. **Statistics**: View registration statistics by mountain location
8. **Save Data**: Save registration data to file
9. **Exit**: Exit the application

## Data Structure

The application uses the following main classes:

- **Student**: Represents a student with ID, name, phone, email, mountain code, and tuition fee
- **Mountain**: Represents a mountain with code, name, province, and description
- **Controllers**: Various controller classes to handle different functionalities
- **Validators**: Validation classes to ensure data integrity

## Validation Rules

- **Student ID**: Must follow the pattern (SE|HE|DE|QE|CE) followed by 6 digits
- **Name**: Must be between 2-20 characters
- **Phone**: Must be a valid 10-digit Vietnamese phone number
- **Email**: Must follow a valid email format
- **Mountain Code**: Must be a valid mountain code from the available list

## Tuition Fee Calculation

- Base fee: 6,000,000 VND
- Discount: 35% for students with Viettel or VNPT phone numbers

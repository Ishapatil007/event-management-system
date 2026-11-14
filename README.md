# Event Management System

A web application built with Spring Boot where admins create events and see who has registered, and users browse and book events.

## Features

**User**
- Register and log in
- View available events (name, date, location, details)
- Book an event

**Admin**
- Log in to the admin dashboard
- Create new events
- View the list of users registered for each event

## Tech Stack

- Java 17
- Spring Boot 4.0.9
- Spring Data JPA (Hibernate)
- Thymeleaf
- MySQL  (or PostgreSQL, whichever your URL uses)
- Maven
- HTML / CSS

## Project Structure

```
src/main/java/com/example/event_management
├── control      # BookingController, EventController, UserController
├── entity       # Booking, Event, User
└── repository   # BookingRepository, EventRepository, UserRepository

src/main/resources
├── templates    # login, register, user-dashboard, admin-dashboard, create-event
└── application.properties
```

## How to Run

1. Clone the repository:
   ```
   git clone https://github.com/YOUR-USERNAME/event-management-system.git
   ```
2. Create a database named `[your_db_name]` in [MySQL].
3. Open `src/main/resources/application.properties` and set your database username and password.
4. Run `EventmanagementApplication.java` (Run As → Spring Boot App), or use:
   ```
   mvn spring-boot:run
   ```
5. Open `http://localhost:8080` in your browser.

## Screenshots

### Login
![Login](Screenshots/Login%20page.png)

### Register
![Register](Screenshots/Register%20Page.png)

### Available Events
![Available Events](Screenshots/Available%20events.png)

### Admin: Event Management
![Event Management](Screenshots/Event%20Management.png)

## Author

[Your Name]
# ReactJS Hands-on Lab: Conditional Rendering

This project, named "ticketbookingapp," was created to fulfill the requirements of my hands-on lab assignment on conditional rendering in React.
This is a project I built as part of `Digital Nurture 4.0 program`.

## Assignment Goal

The main objective of this assignment was to learn and implement conditional rendering. The application needed to display different views and components to the user based on their authentication status (whether they are logged in or not).

## Features Implemented

As required by the assignment, I have built the following functionality:

* **Login/Logout State:** The application maintains a state to track if the user is logged in or logged out.

* **Conditional Views:**
    * When a user is **logged out**, they see a **Guest Page**. This page welcomes them as a guest and shows them flight details, but they cannot book a ticket.
    * When a user is **logged in**, they see a **User Page**. This page welcomes them back and provides them with the option to book a ticket.

* **Conditional Buttons:**
    * A **Login** button is displayed when the user is logged out.
    * A **Logout** button is displayed when the user is logged in.

This entire system is built using an `if-else` condition within the main `App` component to dynamically render the correct page and button.

## Components

I structured the application with the following components in the `src/` folder:

* `App.js`: This is the main component that holds the `isLoggedIn` state and the core logic for conditional rendering.
* `GuestPage.js`: A simple component that displays the view for a logged-out user.
* `UserPage.js`: A simple component that displays the view for a logged-in user.
* The `LoginButton` and `LogoutButton` are small functional components defined directly within `App.js` as suggested by the assignment hints.

## Final Output :

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/12.%20ReactJS-HOL/ticketbookingapp/output_Screenshot/Screenshot%2001.png?raw=true)


![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/12.%20ReactJS-HOL/ticketbookingapp/output_Screenshot/Screenshot%2002.png?raw=true)
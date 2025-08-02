# ReactJS Hands-on Lab: Event Handling Examples

This project was created as part of my hands-on lab assignment to understand and implement various event handling concepts in React as part of `Digital Nurture 4.0 program`.

## Project Overview

The main goal of this application, named `eventexamplesapp`, is to demonstrate how to handle different user interactions and events within a React application. It covers basic event handling, passing arguments to event handlers, using synthetic events, and managing state in class components.

## Features Implemented

As per the assignment requirements, I have implemented the following features:

1.  **Counter Component:**
    * An "Increment" button that increases a counter value.
    * A "Decrement" button that decreases the counter value.
    * The "Increment" button is special because it calls two functions at once: one to update the count and another to log a message to the console.

2.  **Welcome Button:**
    * A "Say Welcome" button that, when clicked, calls a function and passes a string argument ("Welcome") to it, which is then displayed in an alert.

3.  **Synthetic Event Demonstration:**
    * A simple button that demonstrates React's `SyntheticEvent`. When clicked, it logs the entire synthetic event object to the console and shows an alert.

4.  **Currency Convertor:**
    * A small form to convert an amount from Indian Rupees (INR) to Euros (EUR).
    * It takes a number as input for INR, and upon clicking the "Convert" button, it calculates and displays the equivalent amount in EUR.

## Components Created

I have structured the application into the following components, located in the `src/components/` directory:

* `Counter.js`: Manages the counter functionality.
* `Welcome.js`: Contains the button that passes arguments to its handler.
* `SyntheticEvent.js`: Demonstrates the use of synthetic events.
* `CurrencyConvertor.js`: Handles the currency conversion logic.
* `App.js`: The main component that brings all the other components together.

## Final output :


![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/11.%20ReactJS-HOL/eventexamplesapp/output_Screenshot/OUTPUT.png?raw=true)
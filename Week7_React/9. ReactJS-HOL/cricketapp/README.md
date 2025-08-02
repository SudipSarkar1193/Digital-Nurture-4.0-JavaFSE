# 🏏 Cricket App - React JS Assignment
Hey there! This is my submission for the ReactJS Hands-on Lab.
This "Cricket App" is a project I built as part of `Digital Nurture 4.0 program`. It's a simple app I built to practice some of the cool features from ES6 within a React environment.

## 📝 What's this all about?
This project is a small React application called cricketapp. The main goal was to get comfortable with modern JavaScript (ES6) features. I've implemented a couple of different components to show I know how to use things like map(), arrow functions, and destructuring.

The whole app has two main "views" that you can switch between by changing a flag variable in the App.js file.

## ✨ Features Implemented

I went a little beyond the original requirements and added a button to toggle between the different views instead of just using a static variable. It makes the app much more interactive!

### ✨ Features
This app is built around two main components that showcase different ES6 and React concepts:

- **Interactive View Toggling:** I used the useState hook to add a button that switches between the ListofPlayers view and the IndianPlayers view.

- **ListofPlayers Component:** This component is shown first.It renders a list of 11 players and their scores using the `.map()` method. It then displays a second, filtered list of players who have scores of 70 or less, which I accomplished using an ES6 arrow function inside the `.filter()` method.

- **IndianPlayers Component:** This is the second view. It demonstrates array destructuring by separating a list of players into "Odd" and "Even" teams and displaying them.
It also merges two separate arrays of players (
T20Players and RanjiTrophyPlayers) into a single list using the ES6 `spread (...) operator`.



## Output 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/9.%20ReactJS-HOL/cricketapp/Output_Screenshot/Output%2001.png?raw=true)

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/9.%20ReactJS-HOL/cricketapp/Output_Screenshot/Output-2.png?raw=true)
# Blogger App - A React Lab on Conditional Rendering

## Project Overview

This "Blogger App" is a project I built as part of `Digital Nurture 4.0 program`. The main objective was to get comfortable with **conditional rendering** in React. The app displays three different types of content—Course Details, Book Details, and Blog Details. The cool part is that you can use the buttons to choose which components to display on the screen.

## What I Learned in This Lab

This assignment was super helpful! I got to implement several important React concepts:

* **Creating Multiple Components:** I practiced breaking down the UI into smaller, manageable pieces by creating separate components for `CourseDetails`, `BookDetails`, and `BlogDetails`.

* **Passing Data with Props:** I learned how to pass data from a parent component (`App.js`) down to child components. All the course, book, and blog data is stored in `App.js` and sent to the components that need it.

* **Rendering Lists with `.map()`:** I used the `.map()` function to loop through arrays of data. This was much better than hardcoding each list item. I also remembered to use the `key` prop, which React needs to keep track of items in a list.

* **Conditional Rendering Techniques:** This was the main focus of the lab. I implemented a few different methods:
    1.  **`useState` and a `switch` statement:** I used a state variable to hold the current view (`'all'`, `'books'`, etc.). A function with a `switch` statement then returns the correct component(s) based on this state. This felt like the most organized way to handle multiple options.
    2.  **Logical `&&` Operator:** I used this for a simple case: `show === 'all' && <h1>...</h1>`. It was a quick and easy way to render something only if a condition is true.
    3.  **Ternary Operator:** I used the ternary operator (`condition ? if_true : if_false`) to show a different message in the footer depending on whether all components were visible or just one.

* **Basic CSS with Flexbox:** I used CSS Flexbox to create the three-column layout and added a vertical green line between the columns to match the assignment's screenshot.


## Output

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/13.%20ReactJS-HOL/bloggerapp/Output_Screenshot/OUTPUT.png?raw=true)

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/13.%20ReactJS-HOL/bloggerapp/Output_Screenshot/output%202.png?raw=true)

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/13.%20ReactJS-HOL/bloggerapp/Output_Screenshot/output%203.png?raw=true)

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/13.%20ReactJS-HOL/bloggerapp/Output_Screenshot/output%204.png?raw=true)
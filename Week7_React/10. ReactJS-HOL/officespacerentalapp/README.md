# Office Space Rental App (React Lab)

## About This Project

This is a project I built as part of `Digital Nurture 4.0 program`. The main goal of this project was to practice using JSX to build a user interface. The app displays a list of office spaces for rent, showing details like the name, address, and monthly rent.

## What I Learned

This was a great hands-on lab! I got to practice some important React concepts:

- **JSX Syntax:** I learned how to write HTML-like code directly in my JavaScript files. It felt a bit weird at first but makes building components much easier.

- **Creating Components:** The entire application is built inside the main `App` component.

- **Using JavaScript Expressions:** I used curly braces `{}` to embed JavaScript variables and expressions, like displaying the office names and rents.

- **Mapping Arrays to Elements:** Instead of writing the HTML for each office manually, I stored the data in an array of objects and used the `.map()` function to loop through it and render each listing. This was really cool and powerful!

- **Conditional Inline Styling:** I used a ternary operator inside a `style` attribute to change the color of the rent price. If the rent is below Rs. 60000, it shows up in red, and if it's higher, it shows up in green.

## Code :

```jsx
import React from "react";
import "./App.css";

function App() {
  const officeList = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "WeWork", Rent: 75000, Address: "Mumbai" },
    { Name: "Regus", Rent: 58000, Address: "Bangalore" },
  ];

  return (
    <div className="App">
      <h1>Office Space, at Affordable Range</h1>

      <img
        src="https://ctfassets.imgix.net/vh7r69kgcki3/4OCCJgYjYNbWwhVWDBhXQd/6cdcaee9df5bf311bbfc964ba3924203/Web_150DPI-20221216_WeWork_Product_Shoot_Q4_4.jpg?auto=format%20compress&fit=crop&q=50&w=1000"
        width="25%"
        height="25%"
        alt="Office Space"
      />

      {officeList.map((office, index) => (
        <div key={index}>
          <h2>Name: {office.Name}</h2>
          <h3 style={{ color: office.Rent <= 60000 ? "red" : "green" }}>
            Rent: Rs. {office.Rent}
          </h3>
          <h3>Address: {office.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;

```

## Output

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week7_React/10.%20ReactJS-HOL/officespacerentalapp/OutputScreenshot/Output.png?raw=true)

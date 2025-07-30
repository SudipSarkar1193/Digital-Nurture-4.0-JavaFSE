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

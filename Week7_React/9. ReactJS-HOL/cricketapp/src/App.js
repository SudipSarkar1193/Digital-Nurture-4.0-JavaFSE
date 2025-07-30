import React, { useState } from "react";
import "./App.css";
import ListofPlayers from "./ListofPlayers";
import IndianPlayers from "./IndianPlayers";

function App() {
  const [flag, setFlag] = useState(true);

  const toggleFlag = () => {
    setFlag(!flag);
  };

  const BussinessComponent = () =>
    flag ? (
      <div>
        <h1>List of Players</h1>
        <ListofPlayers className="player-list" />
      </div>
    ) : (
      <div>
        <IndianPlayers />
      </div>
    );

  return (
    <div className="App">
      <header className="App-header">
        <h1>Cricket App</h1>
        <button onClick={toggleFlag} className="toggle-button">
          {flag ? "Show Indian Players" : "Show List of Players"}
        </button>
      </header>
      <BussinessComponent />
    </div>
  );
}

export default App;

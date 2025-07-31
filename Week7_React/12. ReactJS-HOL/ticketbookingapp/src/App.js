import React, { useState } from "react";
import UserPage from "./UserPage";
import GuestPage from "./GuestPage";
import "./App.css";

function LoginButton(props) {
  return <button onClick={props.onClick}>Login</button>;
}

function LogoutButton(props) {
  return <button onClick={props.onClick}>Logout</button>;
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  let button;
  let page;

  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
    page = <UserPage />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
    page = <GuestPage />;
  }

  return (
    <div className="App">
      <header className="App-header">
        {page}
        {button}
      </header>
    </div>
  );
}

export default App;

import React from "react";

function UserPage() {
  return (
    <div>
      <h1>Welcome Back!</h1>
      <p>You can now book your tickets.</p>
      <button onClick={() => alert("Ticket booked successfully!")}>
        Book Ticket
      </button>
    </div>
  );
}

export default UserPage;

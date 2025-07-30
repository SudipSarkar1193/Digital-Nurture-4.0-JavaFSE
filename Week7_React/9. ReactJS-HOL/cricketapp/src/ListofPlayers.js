import React from "react";

const ListofPlayers = () => {
  const players = [
    { name: "Dhoni", score: 100 },
    { name: "Sachin", score: 85 },
    { name: "Sehwag", score: 70 },
    { name: "Ganguly", score: 164 },
    { name: "Kohli", score: 90 },
    { name: "Yuvraj", score: 50 },
    { name: "Rahul", score: 30 },
    { name: "Dravid", score: 55 },
    { name: "Hardik", score: 45 },
    { name: "Bhuvi", score: 65 },
    { name: "Jadeja", score: 85 },
    { name: "Ashwin", score: 55 },
    { name: "Kedar", score: 60 },
    { name: "Irfan", score: 90 },
    { name: "Rishabh", score: 95 },
    { name: "KL Rahul", score: 78 },
    { name: "Shikhar", score: 88 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 },
    
  ];

  const playersWithScoresLessThan70 = players.filter(
    (player) => player.score <= 70
  );

  return (
    <div>
      <h2>List of All Players:</h2>
      <ul>
        {players.map((item, index) => (
          <li key={index}>
            Mr. {item.name} <span>{item.score}</span>
          </li>
        ))}
      </ul>

      <hr />

      <h2>List of Players having Scores Less than 70:</h2>
      <ul>
        {playersWithScoresLessThan70.map((item, index) => (
          <li key={index}>
            Mr. {item.name} <span>{item.score}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
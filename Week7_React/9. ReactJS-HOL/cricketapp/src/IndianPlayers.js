import React from "react";

const IndianPlayers = () => {
  const T20Players = [
    "Virat Kohli",
    "Rohit Sharma",
    "Suryakumar Yadav",
    "Hardik Pandya",
    "Jasprit Bumrah",
    "Ravindra Jadeja",
    "Bhuvneshwar Kumar",
    "Yuzvendra Chahal",
    "Shreyas Iyer",
    "Rishabh Pant",
  ];

  const RanjiTrophyPlayers = [
    "Sandeep Sharma",
    "Tanush Kotian",
    "Prasidh Krishna",
    "Navdeep Saini",
    "Avesh Khan",
    "Rahul Tewatia",
    "Deepak Hooda",
    "Prithvi Shaw",
    "Mayank Agarwal",
  ];

  const allIndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

  const OddPlayers = ({ players }) => {
    const [first, , third, , fifth] = players;
    return (
      <div>
        <h3>Odd Players</h3>
        <ul>
          <li>First : {first}</li>
          <li>Third : {third}</li>
          <li>Fifth : {fifth}</li>
        </ul>
      </div>
    );
  };

  const EvenPlayers = ({ players }) => {
    const [, second, , fourth, , sixth] = players;
    return (
      <div>
        <h3>Even Players</h3>
        <ul>
          <li>Second : {second}</li>
          <li>Fourth : {fourth}</li>
          <li>Sixth : {sixth}</li>
        </ul>
      </div>
    );
  };

  return (
    <div>
      <h1>Indian Team</h1>
      <hr />
      <OddPlayers players={allIndianPlayers} />
      <hr />
      <EvenPlayers players={allIndianPlayers} />
      <hr />
      <h2>List of Indian Players Merged:</h2>
      <ul>
        {allIndianPlayers.map((player, index) => (
          <li key={index}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;

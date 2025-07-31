import React from 'react';

const SyntheticEvent = () => {
  const handleClick = (event) => {
    // 'event' is a SyntheticEvent
    console.log(event);
    alert('SyntheticEvent was clicked');
  };

  return (
    <div>
      <h2>Synthetic Event Example</h2>
      <button onClick={handleClick}>Press Me</button>
    </div>
  );
};

export default SyntheticEvent;
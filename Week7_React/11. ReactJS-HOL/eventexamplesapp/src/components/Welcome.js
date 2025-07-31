import React from 'react';

const Welcome = () => {
  const sayWelcome = (message) => {
    alert(message);
  };

  return (
    <div>
      <h2>Welcome Button</h2>
      <button onClick={() => sayWelcome('Welcome')}>Say Welcome</button>
    </div>
  );
};

export default Welcome;
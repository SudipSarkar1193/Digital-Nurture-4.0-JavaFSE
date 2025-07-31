import React from 'react';
import './App.css';
import Counter from './components/Counter';
import Welcome from './components/Welcome';
import SyntheticEvent from './components/SyntheticEvent';
import CurrencyConvertor from './components/CurrencyConvertor';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>React Event Handling Examples</h1>
        <Counter />
        <hr />
        <Welcome />
        <hr />
        <SyntheticEvent />
        <hr />
        <CurrencyConvertor />
      </header>
    </div>
  );
}

export default App;
import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: 0,
      euros: 0
    };
  }

  handleRupeesChange = (event) => {
    this.setState({ rupees: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    // Assuming an exchange rate, e.g., 1 Euro = 90 INR
    const euroValue = this.state.rupees / 90;
    this.setState({ euros: euroValue.toFixed(2) });
  };

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Indian Rupees:
            <input type="number" value={this.state.rupees} onChange={this.handleRupeesChange} />
          </label>
          <button type="submit">Convert</button>
        </form>
        <p>{this.state.rupees} INR is equal to {this.state.euros} EUR</p>
      </div>
    );
  }
}

export default CurrencyConvertor;
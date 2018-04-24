import React, { Component } from 'react';
import MyName from './MyName';
import './App.css'
import Counter from './Counter';

class App extends Component {
  render() {
    return (
      <div>
        <MyName name="리액트" />
        <Counter />
      </div>
    );
  }
}

export default App;

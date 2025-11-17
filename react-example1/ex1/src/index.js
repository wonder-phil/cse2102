import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const myElement= <h1>React is {5 + 5} times better with JSX</h1>;
const myElement2 = (
  <ul> <li>Apples</li>
  <li>Bananas</li>
  <li>Cherries</li>
  </ul>);

class Car extends React.Component
{
constructor(props) { super(props); }
  render() { return <h2>I am a {this.props.model}!</h2>;
}
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Car model='Mustang'/>
);



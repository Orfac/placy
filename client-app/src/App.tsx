import React from 'react';
import logo from './logo.svg';
import './App.css';
import Place from "./components/Place";
import { PlaceInformation } from "./models/PlaceInformation";

function App() {

    let myPlace : PlaceInformation = {
        title: "my place",
        phone: "my phone",
        address: "my adres"
    };
  return (
    <div className="App">
      <Place {...myPlace} />
    </div>
  );
}

export default App;

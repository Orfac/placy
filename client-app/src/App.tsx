import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import Place from "./components/Place";
import {PlaceInformation} from "./models/PlaceInformation";
import {getPlaces} from "./api/PlaceApi";

function App() {


    const [places, setPlaces] = useState(Array<PlaceInformation>());
    const [isSet, setIsSet] = useState(false);
    useEffect(() => {
        const myFunc = async () => {
            let places = await getPlaces();
            setPlaces(places);
        }
        if (!isSet){
            myFunc().then(_ => setIsSet(true));
        }   

    });

    const renderPlaces = () => {
        return places.map(
            place => <li className="list-group-item"><Place {...place} /></li>
        )
    }

    return (
        <div className="App row">
            <div className="col-md-3"/>
            <div className="col-md-6">
            <ul className="list-group-flush">
                {renderPlaces()}
            </ul>
            </div>
            <div className="col-md-3"/>

        </div>
    );
}

export default App;

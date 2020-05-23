import React, {useEffect, useState} from 'react';
import './App.css';
import Place from "./components/Place";
import {getPlaces} from "./api/PlaceApi";

const App = () => {

    const [places, setPlaces] = useState([]);
    const [isSet, setIsSet] = useState(false);
    useEffect(() => {
        const myFunc = async () => {
            let placesJson = await getPlaces();
            setPlaces(placesJson.results);
        }
        if (!isSet){
            myFunc().then(_ => setIsSet(true));
        }   

    });

    const renderPlaces = () => {
        return places.map(
            place => <li key={place.id} className="list-group-item"><Place {...place} /></li>
        )
    }

    return (
        <div className="App row">
            <div className="col-md-2"/>
            <div className="col-md-8">
            <ul className="list-group-flush">
                {places.length > 0 ? renderPlaces() : ""}
            </ul>
            </div>
            <div className="col-md-2"/>

        </div>
    );
}

export default App;

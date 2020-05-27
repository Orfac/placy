import React, { useEffect, useState } from 'react';
import './App.css';
import Place from "./components/Place";
import { getPlaces } from "./api/PlaceApi";
import config from './api/config.json'

const App = () => {

    const [places, setPlaces] = useState([]);
    const [isSet, setIsSet] = useState(false);
    useEffect(() => {
        const myFunc = async () => {
            //let placesJson = await getPlaces();
            let placesJson = {"results": config.content}
            setPlaces(placesJson.results);
        }
        if (!isSet) {
            myFunc().then(_ => setIsSet(true));
        }

    });

    const renderPlaces = () => {
        return places.map(
            place => <li key={place.id} className="list-group-item"><Place {...place} /></li>
        )
    }

    return (
        <div className="App">
                <div className="row m-0">
                    <div className="col-md-2" />
                    <div className="col-md-8 ">
                        <h1>Placy</h1>
                        <h6>Найдите место, куда отведёте свою половинку</h6>
                        <ul className="list-group-flush ">
                            {places.length > 0 ? renderPlaces() : ""}
                        </ul>
                    </div>
                    <div className="col-md-2" />
                </div>
                


        </div>
    );
}

export default App;

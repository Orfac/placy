import React, { useEffect, useState } from 'react';
import './App.css';
import Place from "./components/Place";
import { getPlaces } from "./api/PlaceApi";
import config from './api/config.json';
import Filter from './components/Filter';

const App = () => {

    const [places, setPlaces] = useState([]);
    const [isSet, setIsSet] = useState(false);
    useEffect(() => {
        const init = async () => {
            //let placesJson = await getPlaces();
            let placesJson = { "results": config.content }
            setPlaces(placesJson.results);
        }
        if (!isSet) {
            init().then(_ => setIsSet(true));
        }

    });

    const renderPlaces = () => {
        return places.map(
            place => <li key={place.id} className="list-group-item"><Place {...place} /></li>
        )
    }
    const handleUpdateSettings = (settings) => {

    }
    return (
        <div className="App">
            <div className="row m-0">
                <div className="col-md-2" />
                <div className="col-md-8">
                    <h1>Placy</h1>
                    <h6>Найдите место, куда поведёте свою половинку</h6>

                    <div className="mt-5" ></div>

                    <div className="ml-4">
                        <div className="row">
                            <div className="col-md-10">
                                <input type="text" className="w-100 h-100" placeholder="Место, например 'ресторан'" />
                            </div>
                            <div className="col-md-2">
                                <button className="btn btn-success w-100">Искать</button>
                            </div>
                        </div>

                        <div className="row mt-1">
                            <div className="col-md-12">
                                <div>
                                    <Filter cities={[]} />
                                </div>
                            </div>

                        </div>
                    </div>

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

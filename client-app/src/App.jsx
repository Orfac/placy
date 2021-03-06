import React, { useEffect, useState } from 'react';
import './App.css';
import Place from "./components/Place";
import { getPlaces, getPlaceInfo } from "./api/PlaceApi";
import Filter from './components/Filter';
import loader from './assets/loader.gif';
import { getCities } from './api/CityApi';

const App = () => {
    
    const [places, setPlaces] = useState([]);
    const [isSet, setIsSet] = useState(false);
    const [settings, setSettings] = useState({
        "location": "spb",
        "lat": 59.935020,
        "lon": 30.327052,
        "radius": 99999
    });
    const [isLoading, setIsLoading] = useState(false);
    const [cities, setCities] = useState([]);
    const [query, setQuery] = useState("");
    const [page, setPage] = useState(1);
    const [latestResult, setLatestResult] = useState({});
    const [isNoResults, setIsNoResults] = useState(false);

    useEffect(() => {
        const init = async () => {
            let citiesJson = await getCities();
            setCities(citiesJson);
        }
        if (!isSet) {
            init().then(_ => setIsSet(true));
        }
    });

    const loadPlaces = async (currentPage) => {
        setIsNoResults(false);
        currentPage = (typeof currentPage !== 'number') ? 1 : currentPage;

        if (query.length == 0) {
            setIsNoResults(true);
            return;
        }
        setIsLoading(true);
        let placesJson = await getPlaces(settings, query, currentPage);
        setLatestResult(placesJson);
        let previousPlaces = placesJson.results;
        
        for (let index = 0; index < previousPlaces.length; index++) {
            let placeInfo = await getPlaceInfo(previousPlaces[index].id);
            previousPlaces[index] = placeInfo;
        }

        setPlaces(previousPlaces);
        setIsLoading(false);
        setIsNoResults(previousPlaces.length <= 0);

    }

    const renderPlaces = () => {

        return places.map(
            place => <li key={place.id} className="list-group-item"><Place {...place} /></li>
        )
    }

    const changePage = (value) => {
        setPage(page + value);
        loadPlaces(page + value);
    }


    const handleUpdateSettings = (settingName, settingValue) => {
        let updatedSettings = settings;
        updatedSettings[settingName] = settingValue;
        setSettings(updatedSettings)
    }
    const handleUpdateQuery = (e) => {
        setQuery(e.currentTarget.value);
        setPage(1);
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
                                <input type="text" className="w-100 h-100" id="Main input"
                                    placeholder="Место, например 'ресторан'" onChange={handleUpdateQuery} />
                            </div>
                            <div className="col-md-2">
                                <button className="btn btn-success w-100" onClick={loadPlaces}>Искать</button>
                            </div>
                        </div>

                        <div className="row mt-1">
                            <div className="col-md-12">
                                <div>
                                    <Filter updateSettings={handleUpdateSettings} cities={cities} />
                                </div>
                            </div>

                        </div>
                    </div>

                    {isNoResults ? 
                        <div className="text-danger justify-content-center mt-5">
                            <h4>
                                К сожалению ничего не удалось найти
                            </h4>
                            <h6>
                                Попробуйте поискать что-то более общее, например "кафе"
                            </h6>
                        </div> : ""}
                    
                    {
                        isLoading ?
                            <img className="img-fluid" id="loader" src={loader}></img> :
                            <ul className="list-group-flush ">
                                {places.length > 0 ? <h5 className="mt-lg-5">Список мест</h5> : ""}
                                <ul className="nav justify-content-center mb-2">
                                {latestResult.previous != null ? <li className="nav-item font-weight-bold">
                                    <a href="#" onClick={() => changePage(-1)} className="nav-link">
                                        Предыдущий набор
                                    </a>
                                </li> : ""}
                                {latestResult.next != null ? <li className="nav-item font-weight-bold">
                                    <a href="#" onClick={() => changePage(1)} className="nav-link ">
                                        Следующий набор
                                    </a>
                                </li> : ""}
                            </ul>

                                {places.length > 0 ? renderPlaces() : ""}

                            </ul>
                    }
                    {
                        places.length <= 0 ? "" :
                            <ul className="nav justify-content-center mb-2">
                                {latestResult.previous != null ? <li className="nav-item font-weight-bold">
                                    <a href="#" onClick={() => changePage(-1)} className="nav-link">
                                        Предыдущий набор
                                    </a>
                                </li> : ""}
                                {latestResult.next != null ? <li className="nav-item font-weight-bold">
                                    <a href="#" onClick={() => changePage(1)} className="nav-link ">
                                        Следующий набор
                                    </a>
                                </li> : ""}
                            </ul>
                    }
                </div>
                <div className="col-md-2" />
            </div>



        </div>
    );
}

export default App;

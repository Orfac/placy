import React, { useEffect, useState } from 'react';

const Filter = (updateSettings, cities) => {

    const [isFilterOpen, setIsFilterOpen] = useState(false);
    const [selectedCity, setSelectedCity] = useState("spb");
    const [isFree, setIsFree] = useState(false);
    const [isClose, setIsClosed] = useState(false);
    const [lat, setLat] = useState(59.935020);
    const [lon, setLon] = useState(30.327052);
    const [radius, setRadius] = useState(99999);



    const handleFilterClick = () => { setIsFilterOpen(!isFilterOpen); }

    const handleChangeIsFree = (e) => { 
        setIsFree(e.currentTarget.checked); 
        updateSettings(getCurrentSettings()); 
    }
    const handleChangeIsClosed = (e) => { 
        setIsClosed(e.currentTarget.checked); 
        updateSettings(getCurrentSettings()); 
    }
    const handleCityChange = (e) => { 
        setSelectedCity(e.currentTarget.value); 
        updateSettings(getCurrentSettings());
     }
    const handleLatChange = (e) => {
         setLat(e.currentTarget.value); 
         updateSettings(getCurrentSettings());
    }
    const handleLonChange = (e) => { 
        setLon(e.currentTarget.value);
         updateSettings(getCurrentSettings()); 
    }
    const handleRadiusChange = (e) => { 
        setRadius(e.currentTarget.value); 
        updateSettings(getCurrentSettings()); 
    }

    const getCurrentSettings = () => {
        return {
            "lat": lat,
            "lon": lon,
            "radius": radius,
            "location": selectedCity,
            "is_free": isFree,
            "include_inactual": isClose
        }
    }

    const renderCities = () => {
        cities.map(
            city => <option value={city.slug}>{city.name}</option>
        )
    }
    return (
        <div className="border border-warning rounded">
            <button className="btn btn-outline-warning w-100" onClick={handleFilterClick} >Фильтр</button>
            {isFilterOpen &&
                <div className="mt-3 mb-3">
                    <div className="list-group">
                        <div className="list-group-item">
                            <div className="row">
                                <div className="col-md-4 ">
                                    Город: <span>
                                        <select name="cities" id="cities" onChange={handleCityChange}>
                                            {cities.length > 0 ? renderCities() : <option value="spb">Санкт-Петербург</option>}
                                        </select>
                                    </span>
                                </div>
                                <div className="col-md-4">
                                    Только бесплатные <span><input type="checkbox"
                                        name="isFree" onChange={handleChangeIsFree}></input></span>
                                </div>

                                <div className="col-md-4">
                                    Включая закрытые <span><input type="checkbox"
                                        onChange={handleChangeIsClosed}></input></span>
                                </div>
                            </div>


                        </div>
                        <div className="list-group-item">
                            <div className="row">
                                <div className="col-md-3">
                                    Область поиска:
                            </div>
                                <div className="col-md-3">
                                    Lat <input type="number" className="w-50 h-75"
                                        onChange={handleLatChange} placeholder="59.935020" />
                                </div>
                                <div className="col-md-3">
                                    Lon <input type="number" className="w-50 h-75"
                                        onChange={handleLonChange} placeholder="30.327052" />
                                </div>
                                <div className="col-md-3">
                                    Radius <input type="number" className="w-50 h-75"
                                        onChange={handleRadiusChange} placeholder="99999" />
                                </div>
                            </div>
                        </div>

                    </div>



                </div>
            }
        </div>
    );
}

export default Filter;

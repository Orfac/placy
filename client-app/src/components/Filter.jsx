import React, { useEffect, useState } from 'react';

const Filter = ({ updateSettings, cities }) => {

    const [isFilterOpen, setIsFilterOpen] = useState(false);

    const handleFilterClick = () => { setIsFilterOpen(!isFilterOpen); }

    const handleChangeIsFree = (e) => {
        updateSettings("is_free", e.currentTarget.checked);
    }
    const handleChangeIsClosed = (e) => {
        updateSettings("include_inactual", e.currentTarget.checked);
    }
    const handleCityChange = (e) => {
        updateSettings("location", e.currentTarget.value);
    }
    const handleLatChange = (e) => {
        updateSettings("lat", e.currentTarget.value);
    }
    const handleLonChange = (e) => {
        updateSettings("lon", e.currentTarget.value);
    }
    const handleRadiusChange = (e) => {
        updateSettings("radius", e.currentTarget.value);
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
                                            {cities.length > 0 ? cities.map(
                                                city => <option value={city.slug}>{city.name}</option>) 
                                            : <option value="spb">Санкт-Петербург</option>}
                                        </select>
                                    </span>
                                </div>
                                <div className="col-md-4">
                                    Только бесплатные <span><input type="checkbox"
                                        name="isFree" onChange={handleChangeIsFree}></input></span>
                                </div>

                                <div className="col-md-4">
                                    Включая закрытые <span><input type="checkbox"
                                        name="isClosed" onChange={handleChangeIsClosed}></input></span>
                                </div>
                            </div>


                        </div>
                        <div className="list-group-item">
                            <div className="row">
                                <div className="col-md-3">
                                    Область поиска:
                            </div>
                                <div className="col-md-3">
                                    Lat <input type="number" className="w-50 h-75" name="lat"
                                        onChange={handleLatChange} placeholder="59.935020" />
                                </div>
                                <div className="col-md-3">
                                    Lon <input type="number" className="w-50 h-75" name="lon"
                                        onChange={handleLonChange} placeholder="30.327052" />
                                </div>
                                <div className="col-md-3">
                                    Radius <input type="number" className="w-50 h-75" name="radius"
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

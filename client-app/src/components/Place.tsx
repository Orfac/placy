import React from 'react';
import { PlaceInformation } from "../models/PlaceInformation";

const Place: React.FC<PlaceInformation> = (props) => {
    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title">{props.title}</h5>
                <p className="card-text">With supporting text below as a natural lead-in to additional content.</p>
            </div>
        </div>
    )
}

export default Place;
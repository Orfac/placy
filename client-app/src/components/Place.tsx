import React from 'react';
import { PlaceInformation } from "../models/PlaceInformation";

const Place: React.FC<PlaceInformation> = (props) => {
    let imgUrl = "https://bigpicture.ru/wp-content/uploads/2018/04/17076355_1412071878866746_531784253382328320_n.jpg";
    return (
        <div className="card shadow">
            <div className="row no-gutters">
                <div className="col-md-8">
                    <div className="card-body">
                        <h5 className="card-title">{props.title}</h5>
                        <p className="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <p className="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <p className="card-text">With supporting text below as a natural lead-in to additional content.</p>
                    </div>
                </div>
                <div className="col-md-4">
                    <img src={imgUrl} className="card-img" alt="place"/>
                </div>
            </div>
        </div>
    )
}

export default Place;
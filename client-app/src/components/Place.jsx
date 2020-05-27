import React from 'react';

const Place = (props) => {
    let imgUrl =  props.images == null || props.images[0] == null ? "" : props.images[0].image ;
    let description = props.description.replace("<p>", "").replace("</p>", "");

    return (
        <div className="card shadow hoverable">
            <div className="row no-gutters">
                <div className="col-md-8">
                    <div className="card-body">
                        <h5 className="card-title">{props.title}</h5>
                        <p className="card-text text-left">
                            <b>Адрес: </b> {props.address}
                            <br />
                            <b>Телефон: </b> {props.phone}
                        </p>

                        <div className="card-text overflow-auto text-left">{description}</div>
                    </div>
                </div>
                <div className="col-md-4">

                    <img src={imgUrl} className="card-img" alt="place" />
                    <a href={props.site_url} className="btn btn-outline-primary m-2">Перейти на сайт</a>
                </div>



            </div>
        </div>
    )
}

export default Place;
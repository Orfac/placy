import React from 'react';

const Place = (props) => {
    let imgUrl = props.images[0].image;
    let description = props.description.replace("<p>","").replace("</p>","");
    return (
        <div className="card shadow hoverable text-center">
            <div className="row no-gutters">
                <div className="col-md-8">
                    <div className="card-body">
                        <h5 className="card-title">{props.title}</h5>
                        <div className="row">
                            <div className="col-md-4"></div>
                            <div className="col-md-8">
                                <div className="row">
                                    <svg class="bi bi-building" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M15.285.089A.5.5 0 0 1 15.5.5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5H1a.5.5 0 0 1-.5-.5v-6a.5.5 0 0 1 .418-.493l5.582-.93V3.5a.5.5 0 0 1 .324-.468l8-3a.5.5 0 0 1 .46.057zM7.5 3.846V8.5a.5.5 0 0 1-.418.493l-5.582.93V15h8v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.222l-7 2.624z"/>
                                        <path fill-rule="evenodd" d="M6.5 15.5v-7h1v7h-1z"/>
                                        <path d="M2.5 11h1v1h-1v-1zm2 0h1v1h-1v-1zm-2 2h1v1h-1v-1zm2 0h1v1h-1v-1zm6-10h1v1h-1V3zm2 0h1v1h-1V3zm-4 2h1v1h-1V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm-2 2h1v1h-1V7zm2 0h1v1h-1V7zm-4 0h1v1h-1V7zm0 2h1v1h-1V9zm2 0h1v1h-1V9zm2 0h1v1h-1V9zm-4 2h1v1h-1v-1zm2 0h1v1h-1v-1zm2 0h1v1h-1v-1z"/>
                                    </svg>
                                    <p className="card-text"><b>{props.address}</b></p>
                                </div>
                            </div>
                        </div>
                        <div className="row"> </div>
                        <div className="row">
                            <div className="col-md-4"></div>
                            <div className="col-md-8">
                                <div className="row">
                                    <svg class="bi bi-phone" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M11 1H5a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM5 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H5z"/>
                                        <path fill-rule="evenodd" d="M8 14a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                                    </svg>
                                    <p className="card-text">{props.phone}</p>
                                </div>
                            </div>
                   
                        </div>
                        
                        <div className="card-text overflow-auto">{description}</div>
                    </div>
                </div>
                <div className="col-md-4 h-100">
                    <img src={imgUrl} className="card-img" alt="place"/>
                </div>
            </div>
        </div>
    )
}

export default Place;
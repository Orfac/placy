import {PlaceInformation} from "../models/PlaceInformation";

export async function getPlaces(): Promise<any> {
    const a = fetch("https://kudago.com/public-api/v1.4/places/?page_size=10",
        {
            method: 'GET',
            mode: 'cors',
            headers: {
                'Access-Control-Allow-Origin': '*'
            }
        }).then(
        data => {
            console.log(data);
        }
    );
    return a;
    // console.log(response);
    // let jsonContent = await response.json();
    // return jsonContent.content;
}
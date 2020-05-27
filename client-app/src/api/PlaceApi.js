import config from './config.json'

export async function getPlaces(settings, query) {
    const parametersString = createParametersString(settings);
    const response = await fetch(`${config.url}/search/?q=${query}${parametersString}`);
    return response.json();
}
export async function getPlaceInfo(id){
    const response = await fetch(`${config.url}/places/${id}/`);
    return response.json();
}

function createParametersString(settings){
    let parametersString = "&ctype=place&page_size=5";
    if (settings.include_inactual) parametersString += "&include_inactual=1";
    if (settings.is_free) parametersString += "&is_free=1";
    parametersString += `&location=${settings.location}&lat=${settings.lat}&lon=${settings.lon}&radius=${settings.radius}`;
    return parametersString;
}
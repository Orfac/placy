import config from './config.json'

export async function getCities() {
    const response = await fetch(`${config.url}/locations/`);
    return response.json();
}
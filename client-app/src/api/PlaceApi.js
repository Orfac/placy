import config from './config.json'

export async function getPlaces() {
    const response = await fetch(`${config.url}/places/?page_size=5&fields=id,title,address,site_url,images,phone,description`);
    return response.json();
}
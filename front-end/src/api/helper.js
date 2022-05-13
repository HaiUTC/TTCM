export const fetchAPI = async (url, method, data) => {
    let result;
    if(data) {
        const response = await fetch(url, {
            method,
            headers : {
                'content-type': 'application/json',
            },
            body: JSON.stringify(data)
        });
        result = response.json();
    } else {
        const response = await fetch(url, {
            method,
            headers : {
                'content-type': 'application/json',
            },
        });
        result = response.json();
    }
    return result;
}
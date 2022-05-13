import { fetchAPI } from "./helper";

const checkoutAPI = {
    CHECKOUT: async (data) => {
        const url = `${process.env.REACT_APP_API_URL}/checkout?id=${data}`;
        const result = fetchAPI(url, 'POST', data);
        return result;
    }
}

export default checkoutAPI;
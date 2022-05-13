import { fetchAPI } from "./helper";

const productAPI = {
    GET_PRODUCTS: () => {
        const url = `${process.env.REACT_APP_API_URL}/products`;
        const result = fetchAPI(url, 'GET');
        return result;
    },
    GET_PRODUCT: (params) => {
        const url = `${process.env.REACT_APP_API_URL}/product?id=${params}`;
        const result = fetchAPI(url, 'GET');
        return result;
    },
}

export default productAPI;
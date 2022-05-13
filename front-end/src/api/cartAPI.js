import { fetchAPI } from "./helper";

const cartAPI = {
    ADD_TO_CART: (data) => {
        const url = `${process.env.REACT_APP_API_URL}/addToCart`;
        const result = fetchAPI(url, 'POST', data);
        return result;
    },
    GET_CART: (data) => {
        const url = `${process.env.REACT_APP_API_URL}/cart?customerId=${data}`;
        const result = fetchAPI(url, 'GET');
        return result;
    },
    CHANGE_QUANTITY_CART: (data) => {
        const url = `${process.env.REACT_APP_API_URL}/order-detail/update`;
        const result = fetchAPI(url, 'PUT', data);
        return result;  
    },
    DELETE_CART_ITEM: (data) => {
        const url = `${process.env.REACT_APP_API_URL}/order-detail/delete`;
        const result = fetchAPI(url, 'DELETE', data);
        return result;  
    }
}

export default cartAPI;
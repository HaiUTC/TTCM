import { fetchAPI } from "./helper";

const customerAPI = {
    LOGIN: async (data) => {
        const url = `${process.env.REACT_APP_API_URL}/login`;
        const result = fetchAPI(url, 'POST', data);
        return result;
    },
    REGISTER: data => {
        const url = `${process.env.REACT_APP_API_URL}/register`;
        const result = fetchAPI(url, 'POST', data);
        return result;
    }
}

export default customerAPI;
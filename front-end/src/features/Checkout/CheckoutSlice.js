import { createSlice } from "@reduxjs/toolkit";
import { checkout } from "./pathAPI";


const CheckoutSlice = createSlice({
    name: 'checkout',
    initialState: {
        isSuccess: false,
        loading: true,
        error: ''
    },
    reducers: {},
    extraReducers: {
        [checkout.pending]: (state) => {
            state.loading = true;
        },
        [checkout.rejected]: (state, action) => {
            state.loading = false;
            state.error = action.error;
        },
        [checkout.fulfilled]: (state, action) => {
            state.loading = false;
            state.isSuccess = action.payload
        },     
    }

});
const { reducer} = CheckoutSlice;
export default reducer;
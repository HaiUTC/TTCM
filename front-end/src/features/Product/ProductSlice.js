import { createSlice } from "@reduxjs/toolkit";
import { getProduct } from './pathAPI';

const ProductSlice = createSlice({
    name: 'product',
    initialState: {
        data: {},
        loading: true,
        error: ''
    },
    reducers: {},
    extraReducers: {
        [getProduct.pending]: (state) => {
            state.loading = true;
        },
        [getProduct.rejected]: (state, action) => {
            state.loading = false;
            state.error = action.error;
        },
        [getProduct.fulfilled]: (state, action) => {
            state.loading = false;
            state.data = action.payload
        }
    }

});
const { reducer} = ProductSlice;
export default reducer;
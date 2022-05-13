import { createSlice } from "@reduxjs/toolkit";
import { getProducts } from './pathAPI';

const ProductsSlice = createSlice({
    name: 'product',
    initialState: {
        data: {},
        loading: true,
        error: ''
    },
    reducers: {},
    extraReducers: {
        [getProducts.pending]: (state) => {
            state.loading = true;
        },
        [getProducts.rejected]: (state, action) => {
            state.loading = false;
            state.error = action.error;
        },
        [getProducts.fulfilled]: (state, action) => {
            state.loading = false;
            state.data = action.payload
        }
    }

});
const { reducer} = ProductsSlice;
export default reducer;
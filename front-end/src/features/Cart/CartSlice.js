import { createSlice } from "@reduxjs/toolkit";
import { addCart, cart, changeQuantity, deleteCartItem } from "./pathAPI";


const CartSlice = createSlice({
    name: 'customer',
    initialState: {
        data: null,
        addToCartSuccess: false,
        deleteCartItemSuccess: false,
        loading: true,
        error: ''
    },
    reducers: {},
    extraReducers: {
        [addCart.pending]: (state) => {
            state.loading = true;
        },
        [addCart.rejected]: (state, action) => {
            state.loading = false;
            state.error = action.error;
        },
        [addCart.fulfilled]: (state, action) => {
            state.loading = false;
            state.addToCartSuccess = action.payload
        },

        [cart.pending]: (state) => {
            state.loading = true;
        },
        [cart.rejected]: (state, action) => {
            state.loading = false;
            state.error = action.error;
        },
        [cart.fulfilled]: (state, action) => {
            state.loading = false;
            state.data = action.payload
        },

        [changeQuantity.pending]: (state) => {
            state.loading = true;
        },
        [changeQuantity.rejected]: (state, action) => {
            state.loading = false;
            state.error = action.error;
        },
        [changeQuantity.fulfilled]: (state, action) => {
            state.loading = false;
            // state.data = action.payload
        },

        [deleteCartItem.pending]: (state) => {
            state.loading = true;
        },
        [deleteCartItem.rejected]: (state, action) => {
            state.loading = false;
            state.error = action.error;
        },
        [deleteCartItem.fulfilled]: (state, action) => {
            state.loading = false;
            state.deleteCartItemSuccess = action.payload
        },
    }

});
const { reducer} = CartSlice;
export default reducer;
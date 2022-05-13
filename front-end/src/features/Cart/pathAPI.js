import { createAsyncThunk } from "@reduxjs/toolkit"
import cartAPI from "../../api/cartAPI"


export const cart = createAsyncThunk('cart', async (data) =>{
    const response = await cartAPI.GET_CART(data)
    return response
})

export const addCart = createAsyncThunk('addCart', async (params) => {
    const response = await cartAPI.ADD_TO_CART(params)
    return response
})

export const changeQuantity = createAsyncThunk('changeQuantity', async (params) => {
    const response = await cartAPI.CHANGE_QUANTITY_CART(params)
    return response
})

export const deleteCartItem = createAsyncThunk('deleteCartItem', async (params) => {
    const response = await cartAPI.DELETE_CART_ITEM(params)
    return response
})
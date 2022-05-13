import { createAsyncThunk } from "@reduxjs/toolkit"
import productAPI from '../../api/productAPI'

export const getProducts = createAsyncThunk('getProducts', async (data) =>{
    const response = await productAPI.GET_PRODUCTS()
    return response
})

export const getProduct = createAsyncThunk('getProduct', async (params) => {
    const response = await productAPI.GET_PRODUCT(params)
    return response
})

// export const getProductThum = createAsyncThunk('getProductThum', async (params) => {
//     const response = await productAPI.GET_PRODUCT_THUM(params)
//     return response
// })
import { createAsyncThunk } from "@reduxjs/toolkit"
import customerAPI from '../../api/customerAPI';

export const login = createAsyncThunk('login', async (data) =>{
    const response = await customerAPI.LOGIN(data)
    return response
})

export const register = createAsyncThunk('register', async (params) => {
    const response = await customerAPI.REGISTER(params)
    return response
})

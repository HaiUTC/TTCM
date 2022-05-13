import { createAsyncThunk } from "@reduxjs/toolkit"
import checkoutAPI from "../../api/checkoutAPI"

export const checkout = createAsyncThunk('checkout', async (data) =>{
    const response = await checkoutAPI.CHECKOUT(data)
    return response
})


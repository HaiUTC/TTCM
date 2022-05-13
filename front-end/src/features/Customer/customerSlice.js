import { createSlice } from "@reduxjs/toolkit";
import { login, register } from './pathAPI';

const CustomerSlice = createSlice({
    name: 'customer',
    initialState: {
        data: null,
        loading: true,
        error: ''
    },
    reducers: {},
    extraReducers: {
        [login.pending]: (state) => {
            state.loading = true;
        },
        [login.rejected]: (state, action) => {
            state.loading = false;
            localStorage.removeItem('userId');
            state.error = action.error;
        },
        [login.fulfilled]: (state, action) => {
            state.loading = false;
            localStorage.setItem('userId', action.payload.id);
            state.data = action.payload
        },

        [register.pending]: (state) => {
            state.loading = true;
        },
        [register.rejected]: (state, action) => {
            state.loading = false;
            state.error = action.error;
        },
        [register.fulfilled]: (state, action) => {
            state.loading = false;
            state.data = action.payload
        }
    }

});
const { reducer} = CustomerSlice;
export default reducer;
import { configureStore } from '@reduxjs/toolkit'
import ProductsSlice from '../features/Product/productsSlice'
import ProductSlice from '../features/Product/ProductSlice'
import CustomerSlice from '../features/Customer/customerSlice'
import CartSlice from '../features/Cart/CartSlice'
import CheckoutSlice from '../features/Checkout/CheckoutSlice'

const rootReducer = {
    products: ProductsSlice,
    product: ProductSlice,
    customer: CustomerSlice,
    cart: CartSlice,
    checkout: CheckoutSlice
}
const store = configureStore({
    reducer : rootReducer
})

export default store
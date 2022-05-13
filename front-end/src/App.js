import Header from './component/header'
import {   BrowserRouter,
  Routes,
  Route, } from "react-router-dom";
import { Suspense } from 'react';
import LoadingPage from './component/LoadingPage';
import Login from './page/login';
import Register from './page/register';
import Shop from './page/shop';
import Product from './page/product';
import Footer from './component/footer';
import { CustomerContextProvider } from './app/customerContext';
import NotFound from './page/NotFound';
import Cart from './page/Cart';

function App() {

  return (
    <BrowserRouter>
    <CustomerContextProvider>
      <Header />
      <Suspense fallback={<LoadingPage />}>
          <Routes >
            <Route path="/" element={<Shop />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/cart" element={<Cart />} />
              <Route path="/product/:id" element={<Product />} />
              <Route path='/*' element={<NotFound />}/>
          </Routes>
        </Suspense>
        <Footer />
    </CustomerContextProvider>
    </BrowserRouter>
  );
}

export default App;


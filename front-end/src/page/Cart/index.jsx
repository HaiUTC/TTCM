import produce from 'immer';
import { useContext, useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { CustomerContext } from '../../app/customerContext';
import Banner from '../../component/Banner';
import LoadingPage from '../../component/LoadingPage';
import { cart, changeQuantity, deleteCartItem } from '../../features/Cart/pathAPI';
import { checkout } from '../../features/Checkout/pathAPI';
import './index.css';
const Cart = () => {
    const dispatch = useDispatch();
    const { user } = useContext(CustomerContext);
    const {data,loading} = useSelector((state) => state.cart); 
    const [store, setStore] = useState();

    useEffect(() => {
        if(data){
            setStore(data);
        }
    }, [loading]);

    console.log(store)

    useEffect(() => {
        const fetchProduct = async () => {
            if(user){
                await dispatch(cart(user));
            }
          };
          fetchProduct();
    }, [dispatch, user]); 

    const handleRemoveCartItem = async(productId) => {
        const res = await dispatch(deleteCartItem({
            productId: productId,
            orderId: data.id
        }))
        if(res.payload){
            await dispatch(cart(user));
        } else {
            alert('Delete failure')
        }
    }
    console.log(data)

    const handleChangeQuantity = async (e, productId, index) => {
        const value = e.target.value;
        const res = await dispatch(changeQuantity({
            productId: productId,
            orderId: data.id,
            quantity: +value
        }))
        if(res.payload){
            await dispatch(cart(user));
        } else {
            alert('Change quantity failure')
        }
    }

    const handleCheckout = async () =>{
        const res = await dispatch(checkout(data.id))
        if(res.payload){
            alert('checkout successfully');
            await dispatch(cart(user));
        } else {
            alert('Change quantity failure')
        }
        console.log(res);
    }

    return (
        <>
            {loading ? <LoadingPage />: 
                <>
                    <Banner pageName='Cart'/>
                    {
                        user ?
                            //Render List order item
                            <div className='cart'>
                            <div className='cart_list'>
                                {!store ? <p>There are no items in your bag.</p> : store.carts.map((cart, index) => 
                                    (
                                        <div className='cart_item' key={index}>
                                            <div className='cart_item_img'>
                                                <img src={`${process.env.REACT_APP_API_URL_IMAGE}/${cart.product.image}`} alt={cart.product.name} />
                                            </div>
                                            <div className='cart_item_info'>
                                                <p>{cart.product.name}</p>
                                                <p>{cart.product.brand}</p>
                                                Quantity: <input type='number' value={cart.quantity} onChange={(e) => handleChangeQuantity(e, cart.product.id, index)}/>
                                                <p style={{cursor: "pointer"}} onClick={() => handleRemoveCartItem(cart.product.id)}>Remove</p>
                                            </div>
                                            <div className='cart_item_price'>
                                                <p>${cart.price}.00</p>
                                            </div>
                                        </div>
                                    )
                                )}
                                
                            </div>
                            <div className='summary'>
                                <p>Summary:</p>
                                <p>Total: ${store && store.price}.00</p>
                                <button onClick={handleCheckout}>Checkout</button>
                            </div>
                            </div>
                        : 
                        <p>There are no items in your bag.</p>
                    }
                </>
            }
        </>
    )
}
export default Cart;
/* eslint-disable jsx-a11y/anchor-is-valid */
/* eslint-disable jsx-a11y/anchor-has-content */
import { useContext, useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useLocation, useNavigate } from "react-router-dom";
import { CustomerContext } from "../../app/customerContext";
import LoadingPage from "../../component/LoadingPage";
import { addCart } from "../../features/Cart/pathAPI";
import { getProduct } from "../../features/Product/pathAPI";
import './index.css';
const Product = () => {
    const location = useLocation();
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const { user } = useContext(CustomerContext);
    const id = location.pathname.split('/')[2]
    const [quantity, setQuantity] = useState(1);
    const {data,loading} = useSelector((state) => state.product);  

    useEffect(() => {
        const fetchProduct = async () => {
            await dispatch(getProduct(id));
          };
          fetchProduct();
    }, [dispatch, id]); 

    const handleAddToCart = async () => {
        if(!user) {
            navigate('/login');
        }
        const response = await dispatch(addCart({
            customerId: user,
            productId: id,
            quantity
        }))
        if(response.payload){
            //success( toast)
            alert('Add to cart successfully');
        } else {
            //fail (toast)
            alert('Add to cart failure');
        }
    }
    return (
        <>
            {loading ? <LoadingPage /> :
            <section className="single_product_details_area d-flex align-items-center">
                <div className="single_product_thumb clearfix">
                    <div className="owl-item cloned image_css_custom" style={{width: "793px", marginRight: "0px"}}>
                        <img src={`${process.env.REACT_APP_API_URL_IMAGE}/${data.image}`} alt={data.name} />
                    </div>
        
                    
                </div>
                <div className="single_product_desc clearfix">
                        <span>{data.brand}</span>
                        <a href="cart.html">
                            <h2>{data.name}</h2>
                        </a>
                        <p className="product-price">${data.price}.00</p>
                        <p className="product-desc">{data.description}.</p>
        
                        <form className="cart-form clearfix">
                            <div className="cart-fav-box d-flex align-items-center">
                                <button type="button" onClick={handleAddToCart} className="btn essence-btn">Add to cart</button>
                                <div className="product-favourite ml-4">
                                    <a href="#" className="favme fa fa-heart" />
                                </div>
                                <label style={{fontSize: "17px", paddingLeft: "10px", margin: "0px"}}>Quantity: </label>
                                <input 
                                    style={{fontSize: "17px", padding: "5px 15px", marginLeft: "15px"}}  
                                    type='number' placeholder='Quantity'
                                    value={quantity}
                                    onChange={(e) => setQuantity(e.target.value)}
                                />
                            </div>
                        </form>
                    </div>
            </section>
            }
        </>
        
    )
}
export default Product;
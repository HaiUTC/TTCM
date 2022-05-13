import React, {  useEffect } from "react";
import { useDispatch, useSelector } from 'react-redux';
import Category from '../../component/category';
import ProductToolbar from '../../component/ProductToolbar';
import ProductItem from '../../component/ProductItem';
import Banner from '../../component/Banner';
import LoadingElement from '../../component/LoadingElement'
import {getProducts} from '../../features/Product/pathAPI'
import './index.css';


const Shop = () => {
    const dispatch = useDispatch();
    const {data, loading } = useSelector((state) => state.products);
    useEffect(() => {
        const fetchProduct = async () => {
            await dispatch(getProducts());
          };
          fetchProduct();
    },[dispatch])
    return (
        <div>
            <Banner pageName='Shop'/>
            <div className='grid'>
                <div className='grid_item_category'>
                    <Category />
                </div>
                {loading ? <LoadingElement /> : <div className='grid_item_product'>
                <ProductToolbar numberProducts={data.length}/>
                <div style={{display: 'flex', flexWrap: 'wrap'}}>
                    {data.map(dataItem => 
                        <ProductItem 
                            key={dataItem.id} 
                            data={dataItem}
                        />
                    )}
                </div>
                
            </div>}
                
            </div>
            
        </div>
    )
}
export default Shop;
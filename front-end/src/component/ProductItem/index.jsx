
/* eslint-disable jsx-a11y/anchor-has-content */
const ProductItem = ({data}) => {

    return (
        <div className="col-12 col-sm-6 col-lg-4">
            <div className="single-product-wrapper">
                <div className="product-img">
                    <img src={`${process.env.REACT_APP_API_URL_IMAGE}/${data.image}`} alt={data.name} />
                </div>

                <div className="product-description">
                    <span>{data.brand}</span>
                    <a href={`/product/${data.id}`}>
                        <h6>{data.name}</h6>
                    </a>
                    <p className="product-price">${data.price}</p>

                    
                </div>
            </div>
        </div>
    )
}

export default ProductItem;
const ProductToolbar = ({numberProducts}) => {
    return (
        <div className="product-topbar d-flex align-items-center justify-content-between">
            <div className="total-products">
                <p><span>{numberProducts}</span> products found</p>
            </div>
            <div className="product-sorting d-flex">
                <p>Sort by:</p>
                <form action="#" method="get">
                    <div className="nice-select" >
                        <span className="current">Highest Rated</span>
                        <ul className="list">
                            <li data-value="value" className="option selected">Highest Rated</li>
                            <li data-value="value" className="option">Newest</li>
                            <li data-value="value" className="option">Price: $$ - $</li>
                            <li data-value="value" className="option">Price: $ - $$</li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    )
}
export default ProductToolbar;
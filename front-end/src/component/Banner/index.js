const Banner = ({pageName}) => {
    return (
        <div className="breadcumb_area bg-img" style={{backgroundImage: "url(" + "/image/breadcumb.jpg" + ")"}}>
            <div className="container h-100">
                <div className="row h-100 align-items-center">
                    <div className="col-12">
                        <div className="page-title text-center">
                            <h2>{pageName}</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default Banner;
/* eslint-disable react-hooks/rules-of-hooks */
import { useContext } from 'react';
import { CustomerContext } from '../../app/customerContext';
import './index.css'
const index = () => {
    const { isUser } = useContext(CustomerContext);
    const handleLogout = (e) => {
        e.preventDefault();
        localStorage.removeItem('userId');
        window.location.reload();
    }
    return (
        <header className="header_area">
        <div className="classNamey-nav-container breakpoint-off d-flex align-items-center justify-content-between header_css_custom">
            <nav className='nav1'>
                <a className="nav-brand" href="/"><img src="/image/logo.png" alt="" /></a>
                
            </nav>

            <div className="header-meta d-flex clearfix justify-content-end">

                <div className="search-area">
                    <form action="/" method="post">
                        <input type="search" name="search" id="headerSearch" placeholder="Type for search" />
                        <button type="submit"><i className="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                </div>

                <div className="favourite-area">
                    <a href="/favorite"><img src="/image/heart.svg" alt="" /></a>
                </div>
                <div className="cart-area">
                    <a href="/cart" id="essenceCartBtn"><img src="/image/bag.svg" alt=""/></a>
                </div>

                <div className="user-login-info">
                { isUser ? 
                    <a href="/" onClick={handleLogout} style={{display: "flex", justifyContent: "center"}}><p style={{color: "black", fontSize: "15px", margin: "auto"}}>Logout</p></a> 
                    : 
                    <a href="/login" style={{display: "flex", justifyContent: "center"}}><p style={{color: "black", fontSize: "15px", margin: "auto"}}>Login</p></a>
                }
                    
                </div>

                
            </div>

        </div>
    </header>
    );
};
export default index;
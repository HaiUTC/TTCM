import { createContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom"

const CustomerContext = createContext(null)
const CustomerContextProvider = (props) => {
    const currentPath = window.location.pathname.split('/')[1];
    const navigate = useNavigate();
    const userId = localStorage.getItem('userId');
    const [user,setUser] = useState()
    const [isUser, setIsUser] = useState(false)

    useEffect(() => {
        if(userId) {
            setUser(userId)
            setIsUser(true);
        } else {
            setUser(null);
            setIsUser(false);
        }
    }, [userId]);

    useEffect(() => {
        if(user && (currentPath === 'login' || currentPath === 'register')){
            navigate('/');
        } 
    }, [currentPath, navigate, user]);

    const state = {
        user,
        isUser
    }

    return (
        <CustomerContext.Provider value={state}>
            {props.children}
        </CustomerContext.Provider>
    )
}

export { CustomerContext, CustomerContextProvider}
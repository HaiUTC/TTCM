import { useState } from 'react';
import { useDispatch } from 'react-redux';
import  { useNavigate } from 'react-router-dom';
import Banner from '../../component/Banner';
import { login } from '../../features/Customer/pathAPI';
import './index.css';
const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const hanleChangeEmail = (e) => setEmail(e.target.value);
    const hanleChangePassword = (e) => setPassword(e.target.value);
    const handleLogin = async () => {
        const data = {
            email,
            password
        }
        const response = await dispatch(login(data))
        if(response.payload){
            navigate('/');
        }
    }
    return (
        <>
            <Banner pageName="Login"/>
            <div className='login-detail'>
                <div className='login-element'>
                    <label>Email <span>*</span></label>
                    <input type="text" className="form-control" id="last_name" value={email} required onChange={hanleChangeEmail}></input>
                </div>
                <div className='login-element'>
                    <label>Password<span>*</span></label>
                    <input type="password" className="form-control" id="last_name" value={password} required onChange={hanleChangePassword}></input>
                </div>
                <p>If you not have account. <a href='/register' style={{color: 'black'}}>Register now!</a></p>
                <button onClick={handleLogin} className="btn essence-btn">Login</button>
            </div>
        </>
    )
}
export default Login;
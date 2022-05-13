import { useState } from 'react';
import { useDispatch } from 'react-redux';
import Banner from '../../component/Banner';
import { register } from '../../features/Customer/pathAPI';
import '../login/index.css';
const Register = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [address, setAddress] = useState('');
    const dispatch = useDispatch();
    const hanleChangeName = (e) => setName(e.target.value);
    const hanleChangeEmail = (e) => setEmail(e.target.value);
    const hanleChangePassword = (e) => setPassword(e.target.value);
    const hanleChangeAddress = (e) => setAddress(e.target.value);
    const handleRegister = async () => {
        const data = {
            name,
            email,
            password,
            address
        };
        await dispatch(register(data))
    }
    return (
        <>
            <Banner pageName="Register"/>
            <div className='login-detail'>
                <div className='login-element'>
                    <label>Name <span>*</span></label>
                    <input type="text" className="form-control" id="last_name" value={name} required onChange={hanleChangeName}></input>
                </div>
                <div className='login-element'>
                    <label>Email<span>*</span></label>
                    <input type="email" className="form-control" id="last_name" value={email} required onChange={hanleChangeEmail}></input>
                </div>
                <div className='login-element'>
                    <label>Password<span>*</span></label>
                    <input type="password" className="form-control" id="last_name" value={password} required onChange={hanleChangePassword}></input>
                </div>
                <div className='login-element'>
                    <label>Address<span>*</span></label>
                    <textarea  type="text" className="form-control" id="last_name" value={address} required onChange={hanleChangeAddress}></textarea>
                </div>
                <p>If you already have account. <a href='/login' style={{color: 'black'}}>Login now!</a></p>
                <button onClick={handleRegister} className="btn essence-btn">Register</button>
            </div>
        </>
    )
}
export default Register;
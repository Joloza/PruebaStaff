import React, {useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {getLogin} from "./../services/listaReproduccionApi";
import './../assets/styles.css';


const Login=()=>{

    const [nombre, setNombre] = useState('');
    const [contrasena, setContrasena] = useState('');

    let navigate = useNavigate();

    function handleNameChange(event) {
        setNombre(event.target.value);
    }

    function handleContrasenaChange(event) {
        setContrasena(event.target.value);
    }

    function handleGoRegister(event) {
        event.preventDefault();
        navigate('/UserRegister');
    }

    

    const loginUser = async () => {
        try {
            const response = await getLogin(nombre,contrasena);
            const token = response.data;
            localStorage.setItem('token', token);
            navigate('/Home');
            return token;
        } catch (error) {
            alert("ERROR", error);
            console.error('Error al iniciar sesión:', error);
        }
    }

  const onSubmit = ( event ) => {
    event.preventDefault();
    loginUser();
}

    return(
        

        <div className="formLogin">
            <form onSubmit={(onSubmit)}>
                <div className="input-container">
                    <label>Nombre </label>
                    <input type="text" name="nombre" required onChange={ handleNameChange } placeholder="admin"/>
                </div>
                <div className="input-container">
                    <label>Contraseña </label>
                    <input type="password" name="contrasena" required onChange={ handleContrasenaChange } placeholder="123"/>
                </div>
                <div className="button-container">
                    <input type="submit" />
                </div>
            </form>

            <div>
                <button className='button-eliminar' onClick={handleGoRegister}>Register</button>
            </div>
            
        </div>
        
    );
}

export default Login;
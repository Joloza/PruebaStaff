import React, {useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getLogin,getCrearLista,getConsultarLista,getDescripcionByName,getBorrarLista } from "./../services/listaReproduccionApi";
import axios from 'axios';

const Login=()=>{

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    let navigate = useNavigate();

    function handleEmailChange(event) {
        setEmail(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleSubmit(event) {
        event.preventDefault();

        // Aquí es donde enviarías la solicitud de inicio de sesión al servidor
        // utilizando las credenciales de email y password ingresadas por el usuario
    }

    const loginUser = async (/* email, password */) => {

        /* const data = {
            email: "1@1.com",
            password: "admin"
        };
        const response = await APIInvoke.invokePOST(`/login`, data);
        localStorage.setItem('token', response.token);
        navigate('/Home'); */

        try {
            const response = await axios.post('http://localhost:8081/login', {
                "email": "1@1.com",
                "password":"admin"
            });
        
            // El token de autenticación está en response.data
            const token = response.data;
        
            // Guardar el token en el almacenamiento local (local storage)
            localStorage.setItem('token', token);
        
            // Redirigir a la página principal
            navigate('/Home');
          } catch (error) {
            console.error(error);
          }

    }

    return(
        <div>
            <button onClick={loginUser}>Iniciar sesión</button>
            {/* <form>
                <label>
                    Email:
                    <input type="email" value={email} onChange={handleEmailChange} />
                </label>
                <label>
                    Password:
                    <input type="password" value={password} onChange={handlePasswordChange} />
                </label>
                <button onClick={loginUser}>Iniciar sesión</button>
            </form> */}
        </div>
        
    );
}

export default Login;
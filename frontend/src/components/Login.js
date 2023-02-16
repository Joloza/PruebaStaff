import React, {useState } from 'react';
//import { useNavigate } from 'react-router-dom';
import {getRegistrarUsuario,getLogin,initAxiosInterceptors} from "./../services/listaReproduccionApi";
import axios from 'axios';


const Login=()=>{

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    //let navigate = useNavigate();

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

    const setUser = async () => {
        const datos = {
            "nombre": "Lista 2",
            "email": "1@1.com",
            "password":"admin"
        };
        try {
            const response = await getRegistrarUsuario(datos);
            alert("CREADA");
            console.log('Lista creada con éxito:', response.data);
        } catch (error) {
            alert("ERROR");
            console.error('Error al crear la lista:', error);
        }
    };

    const loginUser = async () => {
        const datos = {
          nombre: "a",
          contrasena: "hola"
        };
        try {
          const response = await getLogin(datos);
          
          alert("No ERROR",response);
        } catch (error) {
          alert("ERROR", error);
          console.error('Error al crear la lista:', error);
        }
    }


    return(
        <div>
            <form>
                <label>
                    Nombre:
                    <input type="email" value={email} onChange={handleEmailChange} />
                </label>
                <label>
                    Contraseña:
                    <input type="password" value={password} onChange={handlePasswordChange} />
                </label>
                <button onClick={setUser}>Registrar usuario</button>
                <button onClick={loginUser}>Iniciar sesión</button>
            </form>
        </div>
        
    );
}

export default Login;